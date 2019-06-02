package uslugi.konwersja

import db.RegulyDbBean
import model.dto.Parametr
import model.dto.Regula
import model.dto.RodzajeAkcjiEnum
import model.dto.WywolanieReguly
import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import reguly.nlp.IFasadaNarzedziaNLP

interface IBudowniczyRegulyDTO {
    fun buduj(id: Long? = null, kod: String? = null, tresc: String): Regula
}

@Component
@Transactional
open class BudowniczyRegulyDTO : IBudowniczyRegulyDTO {

    @Autowired
    lateinit var regulyDbBean: RegulyDbBean;

    @Autowired
    lateinit var fasadaNLP: IFasadaNarzedziaNLP

    override fun buduj(aId: Long?, aKod: String?, tresc: String): Regula {
        val kod = if (!aKod.isNullOrEmpty())
            aKod
        else
            "RS-" + String.format("%03d", regulyDbBean.pobierzNumerKolejnyKodu());
        val trescRegulyStr = tresc.replace("\r", "")
        val sekwencja = fasadaNLP.rozpoznajSekwencje(trescRegulyStr)
        val parametry = wyodrebnijListeParametrow(sekwencja)
        val wywolania = wyodrebnijListeWywolanInnychRegul(sekwencja, kod)
        val pReg = Regula(kod, trescRegulyStr, sekwencja, parametry, wywolania)
        pReg.id = aId
        return pReg
    }


    //var licznikDefaultowychParametrow = 1
    var prefixNazwwyParametruDomyslnego = "param"
    val formatDaty = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]\$"


    data class WrapperTypuParametru(val nazwa: String, val typ: String? = null, val wartoscDomyslna: String? = null)


    fun wyodrebnijListeParametrow(aSekwencja: Sekwencja): MutableList<Parametr> {
        var unikalnySet: MutableSet<String> = linkedSetOf()

        aSekwencja.rozpoznaneTokeny
                .filter {
                    (it.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU
                            || it.typ == RodzajTokenaEnum.PRAWOSTRONNY_OPERAND_WARUNKU)
                            && !unikalnySet.contains(it.wartosc)
                }
                .forEach() {
                    unikalnySet.add(it.wartosc)
                }

        var licznikDefaultowychParametrow = 0
        return unikalnySet.map {
            licznikDefaultowychParametrow += 1
            utworzObiektParametru(it, aSekwencja, licznikDefaultowychParametrow)
        }.toMutableList()

    }

    fun wyodrebnijListeWywolanInnychRegul(aSekwencja: Sekwencja, aKod: String): MutableList<WywolanieReguly> {

        val wywolaniaInnychAkcji = aSekwencja.rozpoznaneTokeny.filter {
            it.typ == RodzajTokenaEnum.AKCJA
                    && it.kategoria == RodzajeAkcjiEnum.SPRAWDZ_REGULE.toString()
        }.toList()


        if (!wywolaniaInnychAkcji.isNullOrEmpty()) {
            return wywolaniaInnychAkcji.map {

                WywolanieReguly(aKod, aSekwencja.podajTokenPoLP(it.lp + 1).wartosc.trim())

            }.toMutableList()

        }
        return mutableListOf()

    }

    /* fun wyodrebnijParametryWywolania(aWywolania: List<WywolanieReguly>, aWszystkieReguly: List<Regula>) {
         val mapa = aWszystkieReguly.map { it.kod to it }.toMap()

         aWywolania.forEach {
             val pRegulaWolana: Regula = mapa[it.kodRegulyWolanej]!!
             it.parametry = pRegulaWolana.parametry.map { ParametrWywolaniaReguly(nazwaParametruRegulyWolanej = it.nazwa) }.toMutableList()

         }


     }*/

    fun utworzObiektParametru(aNazwaParametru: String, aSekwencja: Sekwencja, aNumerKolejny: Int): Parametr {
        val wraperAtrybutow = wnioskujAtrybutyParametru(aNazwaParametru, aSekwencja, aNumerKolejny)
        return Parametr(wraperAtrybutow.nazwa, wraperAtrybutow.typ, wraperAtrybutow.wartoscDomyslna)
    }


    fun wnioskujAtrybutyParametru(aParam: String, aSekwencja: Sekwencja, aNumerKolejny: Int): WrapperTypuParametru {
        if (aSekwencja.podajTokenPoWartosci(aParam)!!.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU) {

            if (aParam.contains("data")) {
                return WrapperTypuParametru(aParam, "Data")
            }

            return WrapperTypuParametru(aParam)
        } else {
            //prawa strona równania
            if (aParam.contains("'") || aParam.contains("\"")) {
                //string data lub liczba, ale na pewno wartosc domyslne
                if (aParam.replace("\"", "").replace("'", "").trim().matches(formatDaty.toRegex())) {
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + aNumerKolejny, "Data", aParam)//wartosc domyslna data

                } else {
                    //wartosc domyslna napis
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + aNumerKolejny, "Napis", aParam)//wartosc domyslna data
                }
            } else {
                var pEwentualnaLiczba = aParam.trim().toIntOrNull()

                if (pEwentualnaLiczba != null) {
                    //wartosc domyslna bedaca liczba
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + aNumerKolejny, "Liczba", aParam)//wartosc domyslna data
                }

                if (aParam.contains("data")) {
                    return WrapperTypuParametru(aParam, "Data")
                }
                //nazwa zmiennej
                return WrapperTypuParametru(aParam)
            }

        }
    }
}