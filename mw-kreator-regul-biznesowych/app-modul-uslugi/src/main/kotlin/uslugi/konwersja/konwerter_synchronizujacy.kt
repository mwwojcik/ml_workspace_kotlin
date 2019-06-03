package uslugi.konwersja

import db.RegulyDbBean
import model.dto.Parametr
import model.dto.Regula
import model.encje.ParametrRegulyEncja
import model.encje.ParametrWywolaniaRegulyEncja
import model.encje.RegulaEncja
import model.encje.WywolanieRegulyEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
open class SynchronizatorDanychBean {

    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    @Autowired
    lateinit var konwerter: RegulaKonwerter

    @Autowired
    lateinit var konwerterParametru: ParametrKonwerter

    @Autowired
    private lateinit var konwerterWywolanRegul:WywolanieRegulyKonwerter

    fun synchronizujDane(aRegula: Regula) {
        //wybierz obiekty ktore sa w bazie ale nie ma ich w pliku

       /* val kodyRegul = aObiektyDoSynchronizacji.map { it.kod }.toList()
        val regulyWgKodow = aObiektyDoSynchronizacji.map { it.kod to it }.toMap()

        val encjeDoUsuniecia =
                regulyDbBean.pobierzRegulyJesliKoduNieMaNaLiscie(kodyRegul).toMutableList()*/


        //kodyRegul.forEach {
            //sprobuj pobrac obiekt po kodzie
            val pEncja = regulyDbBean.pobierzRegulePoKodzie(aRegula.kod)

            if (pEncja == null) {
                //sprawa prosta - obiektu nie ma - dodajemy
                konwerter.konwertujDoEncji(aRegula)
            } else {
                //tu jest trudniej - trzeba zrobic merge
                if (pEncja.tresc != aRegula.tresc) {
                    //tresc reguly w bazie rozni sie od tresci w pliku
                    //regula sie zmienila, plik ma pierwszenstwo

                    val pRegulaDto = aRegula

                    val pWywolaniaNieaktualneParametry =
                            regulyDbBean.pobierzWszystkieWywolaniaDoReguly(pEncja).toMutableList()

                    //List<ParametrRegulyEncja> parametry
                    val parametryNoweEncje = pRegulaDto.parametry?.map {
                        konwerterParametru.konwertujDoEncji(it)
                    }.toList()

                    //val pUsuniete:MutableList<WywolanieRegulyEncja> = mutableListOf()
                    pWywolaniaNieaktualneParametry.forEach {
                        //sprawdzam czy wywolanie jest aktualne
                        val pRegulaWolajacaDto=konwerter.konwertujDoTransportu(it.regulaWolajaca)
                        val czyNadalAktualne=pRegulaWolajacaDto?.wywolaniaRegul?.map { it.kodRegulyWolanej }?.toList()?.contains(pEncja.kod)?:false

                        it.parametry.forEach {
                            regulyDbBean.usunObiektZarzadzalny(it)
                        }
                        it.parametry.clear()
                       /* if(!czyNadalAktualne){
                            regulyDbBean.usunObiektZarzadzalny(it)
                            it.regulaWolajaca.wywolaniaRegul.remove(it)
                            pUsuniete.add(it)
                        }*/
                    }


                   // pWywolaniaNieaktualneParametry.removeAll(pUsuniete)

                    //usuwam stary zestaw parametrow
                    pEncja.parametry?.forEach {
                        regulyDbBean.usunObiektZarzadzalny(it)
                    }

                    //encje przepinam na nowe
                    pEncja.parametry = parametryNoweEncje
                    parametryNoweEncje.forEach{
                        it.regula=pEncja
                    }

                    //dla wszystkich wywolan trzeba odtworzyc parametry
                    pWywolaniaNieaktualneParametry?.forEach { pWywolanie ->
                        parametryNoweEncje?.forEach {
                            val pWywolanieParamEncja = regulyDbBean.podajObiektZarzadzalny(null, ParametrWywolaniaRegulyEncja::class.java)
                            pWywolanieParamEncja.parametrRegulyWolanej = it
                            pWywolanieParamEncja.wywolanie = pWywolanie
                            pWywolanie.parametry.add(pWywolanieParamEncja)
                        }
                    }

                    pEncja.tresc=pRegulaDto.tresc

                    pEncja.wywolaniaRegul.forEach{
                        regulyDbBean.usunObiektZarzadzalny(it)
                    }

                    pEncja.wywolaniaRegul=null

                    pEncja.wywolaniaRegul=pRegulaDto.wywolaniaRegul.map {
                        konwerterWywolanRegul.konwertujDoEncji(it)
                    }.toMutableSet()

                }
            }
        //}

        //usunEncje(encjeDoUsuniecia)
    }


    fun usunReguleRazemZOdwolaniami(aRegula: RegulaEncja) {
        regulyDbBean.usunRegule(aRegula)
    }


    fun usunEncje(encjeDoUsuniecia: List<RegulaEncja>) {
        encjeDoUsuniecia.forEach {
            usunReguleRazemZOdwolaniami(it)
        }
    }


    fun czyParametrySaSpojne(aParametryDto: List<Parametr>, aParametryEncja: List<ParametrRegulyEncja>): Boolean {
        if (aParametryDto.size != aParametryEncja.size) {
            return false
        }
        val nazwyDto = aParametryDto.map { it.nazwa }.toSet()
        val nazwyEncja = aParametryEncja.map { it.nazwa }.toSet()

        return (nazwyDto - nazwyEncja).size == 0
    }

}