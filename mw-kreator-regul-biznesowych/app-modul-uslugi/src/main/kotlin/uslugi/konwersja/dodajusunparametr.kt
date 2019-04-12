package uslugi.konwersja

import model.dto.Parametr
import model.dto.Regula
import model.encje.ParametrWywolaniaRegulyEncja
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
open class DodajUsunParametrKonwerter : BazowyKonwerter() {
    @Autowired
    lateinit var konwerter: ParametrKonwerter
    @Autowired
    lateinit var wywolanieRegulyKonwerter: WywolanieRegulyKonwerter

    fun dodajParametr(aRegula: Regula, aParametr: Parametr) {
        val pEncja = podajObiektZarzadzalny(aRegula.id, RegulaEncja::class.java)
        val pParamEncja = konwerter.konwertujDoEncji(aParametr)

        pParamEncja.regula = pEncja
        pEncja.parametry.add(pParamEncja)


        val pWywolaniaReguly =
                regulyDbBean.pobierzWszystkieWywolaniaDoReguly(pEncja).toMutableList()

        //dla kazdego wywolania dodaj jeden parametr

        pWywolaniaReguly?.forEach {
            val pEncjaParametruWywolania = regulyDbBean.podajObiektZarzadzalny(null, ParametrWywolaniaRegulyEncja::class.java)
            pEncjaParametruWywolania.wywolanie = it
            pEncjaParametruWywolania.parametrRegulyWolanej = pParamEncja

            it.parametry.add(pEncjaParametruWywolania)
        }

    }

    fun usunParametr(aRegula: Regula, aParametr: Parametr) {
        val pEncja = podajObiektZarzadzalny(aRegula.id, RegulaEncja::class.java)
        val pParamEncja = konwerter.konwertujDoEncji(aParametr)


        val pWywolaniaReguly =
                regulyDbBean.pobierzWszystkieWywolaniaDoReguly(pEncja).toMutableList()

        val pDoUsuniecia= mutableListOf<ParametrWywolaniaRegulyEncja>()
        pWywolaniaReguly?.forEach {pWywolanie->
            pWywolanie.parametry.forEach { paramW ->
                if (paramW.parametrRegulyWolanej == pParamEncja){
                    pDoUsuniecia.add(paramW)
                }
            }
        }

        pDoUsuniecia.forEach {
            it.wywolanie.parametry.remove(it)
            regulyDbBean.usunObiektZarzadzalny(it)
        }

        pParamEncja.regula = null
        pEncja.parametry.remove(pParamEncja)
        regulyDbBean.usunObiektZarzadzalny(pParamEncja)

    }
}