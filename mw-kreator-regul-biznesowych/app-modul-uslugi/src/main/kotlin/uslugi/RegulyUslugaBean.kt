package uslugi

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
import model.dto.*
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import reguly.nlp.IFasadaNarzedziaNLP
import uslugi.konwersja.DodajUsunParametrKonwerter
import uslugi.konwersja.IBudowniczyRegulyDTO
import uslugi.konwersja.RegulaKonwerter
import uslugi.konwersja.SynchronizatorDanychBean
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.annotation.PostConstruct
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
open class RegulyUslugaBean {

    @Autowired
    lateinit var konwerter: RegulaKonwerter

    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    @Autowired
    lateinit var synchronizatorDanych: SynchronizatorDanychBean

    @Autowired
    lateinit var budowniczyRegulyDTO:IBudowniczyRegulyDTO;

    @Autowired
    lateinit var dodajUsunParametrKonwerter: DodajUsunParametrKonwerter

    //val reguly: MutableMap<String, Regula> = mutableMapOf()


    @Transactional
    fun podajReguly(): List<Regula> {

        val wart= regulyDbBean.pobierzWszystkieReguly().map {
            konwerter.konwertujDoTransportu(it)
        }.toList()

        return wart
    }

    @Transactional
    fun zapiszReguly(aReguly: List<Regula>) {
        aReguly.forEach {
            konwerter.konwertujDoEncji(it)
        }
    }

    @Transactional
    fun zapiszRegule(aKod:String,aTresc:String) {
        konwerter.konwertujDoEncji(budowniczyRegulyDTO.buduj(aKod,aTresc))
    }

    @Transactional
    fun usunRegule(aId:Long){
        regulyDbBean.usunRegule(aId)
    }

    @Transactional
    fun dodajParametr(aRegula:Regula,aNazwaParametru: String){
        if(!aRegula.parametry.map { it.nazwa }.toList().contains(aNazwaParametru)) {
            val pParam=Parametr(aNazwaParametru,czyUsuwalny = 1)
            dodajUsunParametrKonwerter.dodajParametr(aRegula,pParam)
        }

    }

    @Transactional
    fun usunParametr(aRegula:Regula){
       val pParam=aRegula.parametry.last()

        if(pParam.czyUsuwalny==0){
            return
        }

        dodajUsunParametrKonwerter.usunParametr(aRegula,pParam)

    }


    //**********************************


}




/*
*
1. “1/1/2010” , “01/01/2020”
2. “31/1/2010”, “31/01/2020”
3. “29/2/2008”, “29/02/2008”
4. “28/2/2009”, “28/02/2009”
5. “31/3/2010”, “31/03/2010”
6. “30/4/2010”, “30/04/2010”
7. “31/5/2010”, “31/05/2010”
8. “30/6/2010”, “30/06/2010”
9. “31/7/2010”, “31/07/2010”
10. “31/8/2010”, “31/08/2010”
11. “30/9/2010”, “30/09/2010”
12. “31/10/2010”, “31/10/2010”
13. “30/11/2010”, “30/11/2010”
14. “31/12/2010”, “31/12/2010”
* */