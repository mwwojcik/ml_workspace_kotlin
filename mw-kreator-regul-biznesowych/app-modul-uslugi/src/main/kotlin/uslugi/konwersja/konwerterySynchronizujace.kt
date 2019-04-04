package uslugi.konwersja

import db.RegulyDbBean
import model.dto.Regula
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Component
open class SynchronizatorDanychBean{

    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    @Autowired
    lateinit var konwerter:RegulaKonwerter

    @Transactional
    fun synchronizujDane(aObiektyDoSynchronizacji:List<Regula>){
    //wybierz obiekty ktore sa w bazie ale nie ma ich w pliku

        val kodyRegul=aObiektyDoSynchronizacji.map{it.kod}.toList()
        val regulyWgKodow=aObiektyDoSynchronizacji.map { it.kod to it }.toMap()

        val encjeDoUsuniecia=
                regulyDbBean.pobierzRegulyJesliKoduNieMaNaLiscie(kodyRegul).toMutableList()


        kodyRegul.forEach{
            //sprobuj pobrac obiekt po kodzie
            val pEncja=regulyDbBean.pobierzRegulePoKodzie(it)

            if(pEncja==null){
                //sprawa prosta - obiektu nie ma - dodajemy
                konwerter.konwertujDoEncji(regulyWgKodow[it]!!)
            }else{
                //tu jest trudniej - trzeba zrobic merge
                if(pEncja.tresc!=regulyWgKodow[it]!!.tresc){
                    //tresc reguly w bazie rozni sie od tresci w pliku
                    //regula sie zmienila, plik ma pierwszenstwo
                    //usuwam obiekt i dodaje na nowo
                    //i dodajemy na nowo z aktualnymi wartosciami
                    regulyDbBean.usunRegule(pEncja)
                    konwerter.konwertujDoEncji(regulyWgKodow[it]!!)
                }
            }
        }

        usunEncje(encjeDoUsuniecia)
    }


    @Transactional
    fun usunEncje(encjeDoUsuniecia:List<RegulaEncja>){
        encjeDoUsuniecia.forEach{
            regulyDbBean.usunRegule(it)
        }
    }

}