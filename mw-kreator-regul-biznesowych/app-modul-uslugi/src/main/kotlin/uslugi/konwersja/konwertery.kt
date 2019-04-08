package uslugi.konwersja

import db.RegulyDbBean
import model.dto.*
import model.encje.*
import model.nlp.RodzajTokenaEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import reguly.nlp.IFasadaNarzedziaNLP


@Component
open class RegulaKonwerter : BazowyKonwerter(), IKonwerter<Regula, RegulaEncja> {

    @Autowired
    private lateinit var fasadaNLP: IFasadaNarzedziaNLP

    @Autowired
    private lateinit var konwerterParametrow: ParametrKonwerter

    @Autowired
    private lateinit var konwerterWywolanRegul:WywolanieRegulyKonwerter

    override fun konwertujDoEncji(aDto: Regula): RegulaEncja {
        val pEncja: RegulaEncja = podajObiektZarzadzalny<RegulaEncja>(aDto.id, RegulaEncja::class.java)
        with(aDto) {
            pEncja.kod = kod
            pEncja.tresc = tresc
            pEncja.parametry = parametry.map {
                val pParam = konwerterParametrow.konwertujDoEncji(it)
                pParam.regula = pEncja
                pParam
            }.toMutableList()

            pEncja.wywolaniaRegul=wywolaniaRegul.map {
                konwerterWywolanRegul.konwertujDoEncji(it)
            }.toMutableList()

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
            }.toMutableList())
            pDto.id = id
            pDto.wersja = wersja
            return pDto
        }
    }
}

@Component
open class ParametrKonwerter : BazowyKonwerter(), IKonwerter<Parametr, ParametrRegulyEncja> {

    override fun konwertujDoEncji(aDto: Parametr): ParametrRegulyEncja {
        val pEncja: ParametrRegulyEncja = podajObiektZarzadzalny<ParametrRegulyEncja>(aDto.id, ParametrRegulyEncja::class.java)
        with(aDto) {
            pEncja.nazwa = nazwa
            pEncja.typ = typ
            pEncja.wartoscDomyslna = wartoscDomyslna
            return pEncja
        }
    }

    override fun konwertujDoTransportu(aEncja: ParametrRegulyEncja): Parametr {
        with(aEncja) {
            val pDto = Parametr(nazwa, typ, wartoscDomyslna)
            pDto.id = id
            pDto.wersja = wersja
            return pDto
        }
    }
}

@Component
class WywolanieRegulyKonwerter : BazowyKonwerter(), IKonwerter<WywolanieReguly, WywolanieRegulyEncja> {

    override fun konwertujDoEncji(aDto: WywolanieReguly): WywolanieRegulyEncja {
        val pEncja: WywolanieRegulyEncja = podajObiektZarzadzalny<WywolanieRegulyEncja>(aDto.id, WywolanieRegulyEncja::class.java)
        with(aDto) {
            pEncja.regulaWolajaca = regulyDbBean.pobierzRegulePoKodzie(kodRegulyWolajacej)
            pEncja.regulaWolana = regulyDbBean.pobierzRegulePoKodzie(kodRegulyWolanej)
            pEncja.parametry = parametry.map {
                podajEncjeParametruWywolania(it, pEncja)
            }.toMutableList()
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
            val pDto = ParametrWywolaniaReguly(parametrRegulyWolajacej.nazwa, parametrRegulyWolanej.nazwa)

            pDto.id = id
            pDto.wersja = wersja

            return pDto
        }
    }
}


@Component
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





