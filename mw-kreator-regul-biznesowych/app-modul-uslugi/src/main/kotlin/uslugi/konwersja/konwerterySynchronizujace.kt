package uslugi.konwersja

import db.RegulyDbBean
import model.dto.Parametr
import model.dto.Regula
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
open class SynchronizatorDanychBean {

    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    @Autowired
    lateinit var konwerter: RegulaKonwerter

    @Transactional
    fun synchronizujDane(aObiektyDoSynchronizacji: List<Regula>) {
        //wybierz obiekty ktore sa w bazie ale nie ma ich w pliku

        val kodyRegul = aObiektyDoSynchronizacji.map { it.kod }.toList()
        val regulyWgKodow = aObiektyDoSynchronizacji.map { it.kod to it }.toMap()

        val encjeDoUsuniecia =
                regulyDbBean.pobierzRegulyJesliKoduNieMaNaLiscie(kodyRegul).toMutableList()


        kodyRegul.forEach {
            //sprobuj pobrac obiekt po kodzie
            val pEncja = regulyDbBean.pobierzRegulePoKodzie(it)

            if (pEncja == null) {
                //sprawa prosta - obiektu nie ma - dodajemy
                konwerter.konwertujDoEncji(regulyWgKodow[it]!!)
            } else {
                //tu jest trudniej - trzeba zrobic merge
                if (pEncja.tresc != regulyWgKodow[it]!!.tresc) {
                    //tresc reguly w bazie rozni sie od tresci w pliku
                    //regula sie zmienila, plik ma pierwszenstwo
                    //usuwam obiekt i dodaje na nowoz aktualnymi wartosciami
                    usunReguleRazemZOdwolaniami(pEncja)
                    konwerter.konwertujDoEncji(regulyWgKodow[it]!!)
                } else {
                    //tresc ta sama porownujemy parametry

                  /*  if (!czyParametrySaSpojne(regulyWgKodow[it]!!.parametry, pEncja.parametry ?: emptyList())) {
                        usunReguleRazemZOdwolaniami(pEncja)
                        konwerter.konwertujDoEncji(regulyWgKodow[it]!!)
                    }*/
                }
            }
        }

        usunEncje(encjeDoUsuniecia)
    }


    fun usunReguleRazemZOdwolaniami(aRegula:RegulaEncja){
        regulyDbBean.usunWszystkieWywolaniaDoReguly(aRegula)
        regulyDbBean.usunRegule(aRegula)
    }

    @Transactional
    fun usunEncje(encjeDoUsuniecia: List<RegulaEncja>) {
        encjeDoUsuniecia.forEach {
            usunReguleRazemZOdwolaniami(it)
        }
    }

    @Transactional
    fun czyParametrySaSpojne(aParametryDto: List<Parametr>, aParametryEncja: List<ParametrRegulyEncja>): Boolean {
        if (aParametryDto.size != aParametryEncja.size) {
            return false
        }
        val nazwyDto = aParametryDto.map { it.nazwa }.toSet()
        val nazwyEncja = aParametryEncja.map { it.nazwa }.toSet()

        return (nazwyDto - nazwyEncja).size == 0
    }

}