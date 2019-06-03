package uslugi.konwersja

import db.RegulyDbBean
import model.dto.*
import model.encje.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import reguly.nlp.IFasadaNarzedziaNLP


@Component
@Transactional
open class RegulaKonwerter : BazowyKonwerter(), IKonwerter<Regula, RegulaEncja> {

    @Autowired
    private lateinit var fasadaNLP: IFasadaNarzedziaNLP

    @Autowired
    private lateinit var konwerterParametrow: ParametrKonwerter

    @Autowired
    private lateinit var konwerterWywolanRegul: WywolanieRegulyKonwerter

    override fun konwertujDoEncji(aDto: Regula): RegulaEncja {
        val pEncja: RegulaEncja = podajObiektZarzadzalny<RegulaEncja>(aDto.id, RegulaEncja::class.java)
        with(aDto) {

            val parametryDoUsunieciaStr: Set<String>? = dajParametryDoUsuniecia(parametry, pEncja.parametry)

            val parametryDoUsuniecia: List<ParametrRegulyEncja>? = pEncja.parametry?.filter {
                parametryDoUsunieciaStr?.contains(it.nazwa) ?: false
            }?.toList()

            parametryDoUsuniecia?.forEach {
                regulyDbBean.usunWszystkieOdwolaniaDoParametru(it)
                regulyDbBean.usunObiektZarzadzalny(it)
            }

            pEncja.kod = kod
            pEncja.tresc = tresc
            pEncja.parametry = parametry.map {
                val pParam = konwerterParametrow.konwertujDoEncji(it)
                pParam.regula = pEncja
                pParam
            }.toMutableList()

            pEncja.wywolaniaRegul = wywolaniaRegul.map {
                konwerterWywolanRegul.konwertujDoEncji(it)
            }.toMutableSet()


        }

        return pEncja;
    }

    override fun konwertujDoTransportu(aEncja: RegulaEncja): Regula {
        with(aEncja) {
            val pDto = Regula(kod
                    , tresc
                    , fasadaNLP.rozpoznajSekwencje(tresc)
                    , parametry.map {
                konwerterParametrow.konwertujDoTransportu(it)
            }.toMutableList()
                    , wywolaniaRegul.map {
                konwerterWywolanRegul.konwertujDoTransportu(it)
            }.toMutableList()
            )
            pDto.id = id
            pDto.wersja = wersja
            return pDto
        }
    }

    fun dajParametryDoUsuniecia(aParametryDto: List<Parametr>?, aParametryEncja: List<ParametrRegulyEncja>?): Set<String> {

        val nazwyDto = aParametryDto?.map { it.nazwa }?.toSet() ?: emptySet()
        val nazwyEncja = aParametryEncja?.map { it.nazwa }?.toSet() ?: emptySet()

        return (nazwyEncja - nazwyDto)
    }
}

@Component
@Transactional
open class ParametrKonwerter : BazowyKonwerter(), IKonwerter<Parametr, ParametrRegulyEncja> {

    override fun konwertujDoEncji(aDto: Parametr): ParametrRegulyEncja {
        val pEncja: ParametrRegulyEncja = podajObiektZarzadzalny<ParametrRegulyEncja>(aDto.id, ParametrRegulyEncja::class.java)
        with(aDto) {
            pEncja.nazwa = nazwa
            pEncja.typ = typ
            pEncja.wartoscDomyslna = wartoscDomyslna
            pEncja.czyUsuwalny = czyUsuwalny
            return pEncja
        }
    }

    override fun konwertujDoTransportu(aEncja: ParametrRegulyEncja): Parametr {
        with(aEncja) {
            val pDto = Parametr(nazwa, typ, wartoscDomyslna, czyUsuwalny)
            pDto.id = id
            pDto.wersja = wersja
            return pDto
        }
    }
}

@Component
@Transactional
class WywolanieRegulyKonwerter : BazowyKonwerter(), IKonwerter<WywolanieReguly, WywolanieRegulyEncja> {

    override fun konwertujDoEncji(aDto: WywolanieReguly): WywolanieRegulyEncja {
        val pEncja: WywolanieRegulyEncja = podajObiektZarzadzalny<WywolanieRegulyEncja>(aDto.id, WywolanieRegulyEncja::class.java)
        with(aDto) {
            pEncja.regulaWolajaca = regulyDbBean.pobierzRegulePoKodzie(kodRegulyWolajacej)
            pEncja.regulaWolana = regulyDbBean.pobierzRegulePoKodzie(kodRegulyWolanej)

            if(!parametry.isNullOrEmpty()) {
                pEncja.parametry = parametry.map {
                    podajEncjeParametruWywolania(it, pEncja)
                }.toMutableList()
            }else{
                //jest wywolanie ale nie ma parametrow, wiec inicjalnie trzeba zalozyc
                pEncja.regulaWolana.parametry.forEach {
                    val pParam: ParametrWywolaniaRegulyEncja = podajObiektZarzadzalny<ParametrWywolaniaRegulyEncja>(null, ParametrWywolaniaRegulyEncja::class.java)
                    pParam.wywolanie=pEncja
                    pParam.parametrRegulyWolanej=it
                    pEncja.parametry= mutableListOf<ParametrWywolaniaRegulyEncja>()
                    pEncja.parametry.add(pParam)
                }
            }
        }

        return pEncja
    }

    fun podajEncjeParametruWywolania(aDto: ParametrWywolaniaReguly, aEncjaWywolania: WywolanieRegulyEncja)
            : ParametrWywolaniaRegulyEncja {
        val pEncja: ParametrWywolaniaRegulyEncja = podajObiektZarzadzalny<ParametrWywolaniaRegulyEncja>(aDto.id, ParametrWywolaniaRegulyEncja::class.java)
        with(aDto) {
            pEncja.parametrRegulyWolajacej = regulyDbBean.pobierzParametrRegulyPoNazwie(aEncjaWywolania.regulaWolajaca, nazwaParametruRegulyWolajacej)
            pEncja.parametrRegulyWolanej = regulyDbBean.pobierzParametrRegulyPoNazwie(aEncjaWywolania.regulaWolana, nazwaParametruRegulyWolanej)
            pEncja.wywolanie = aEncjaWywolania
        }

        return pEncja
    }


    override fun konwertujDoTransportu(aEncja: WywolanieRegulyEncja): WywolanieReguly {

        with(aEncja) {
            val pDto = WywolanieReguly(regulaWolajaca.kod, regulaWolana.kod)

            pDto.nazwyParametrowRegulyWolajacej=regulaWolajaca.parametry.map{it.nazwa}.toList()

            pDto.parametry =
                    parametry.map {
                        podajObiektTransportowyParametruWywolania(it)
                    }.toMutableList()

            pDto.id = id
            pDto.wersja = wersja

            return pDto
        }
    }

    fun podajObiektTransportowyParametruWywolania(aEncja: ParametrWywolaniaRegulyEncja): ParametrWywolaniaReguly {
        with(aEncja) {
            val pDto = ParametrWywolaniaReguly(parametrRegulyWolajacej?.nazwa ?: "", parametrRegulyWolanej.nazwa)

            pDto.id = id
            pDto.wersja = wersja

            return pDto
        }
    }
}


@Component
@Transactional
open class BazowyKonwerter {
    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    fun <T : Encja> podajObiektZarzadzalny(aId: Long?, aTypObiektuZarzadzalnego: Class<T>): T {
        return regulyDbBean.podajObiektZarzadzalny(aId, aTypObiektuZarzadzalnego)
    }
}


interface IKonwerter<M1 : ObiektBazowy, M2 : Encja> {

    fun konwertujDoEncji(aDto: M1): M2

    fun konwertujDoTransportu(aEncja: M2): M1

}





