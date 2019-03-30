package uslugi

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.annotation.PostConstruct

@Service
@Transactional
open class RegulyUslugaBean {
    @Autowired
    lateinit var regulyDbBean: RegulyDbBean


    @Autowired
    lateinit var egzaminator: EgzaminatorModeluRozpoznawaniaEncjiNLP

    val reguly: MutableMap<String, String> = mutableMapOf()

    @PostConstruct
    fun inicjalizuj(): Unit {
        val plistaRegul = String(this::class.java.classLoader.getResourceAsStream("reguly.reg").readBytes()).split("\n")

        var i: Int = 0;

        plistaRegul.forEach({
            val pRegList = it.split(":")
            reguly.put(pRegList[0], pRegList[1].replace("\r", ""))
        })
    }


    fun podajReguly(): List<RegulaEncja> {
        return zaladujRegulyDoObiektow()
    }

    fun zaladujRegulyDoObiektow():List<RegulaEncja>{
        val pListaEncji= mutableListOf<RegulaEncja>()

        for ((key, value) in reguly) {
            var pEncja=regulyDbBean.pobierzRegulePoKodzie(key)

            if(pEncja==null){
                pEncja=utworzObiektReguly(key,value)
            }

            pEncja.sekwencja = egzaminator.rozpoznajSekwencje(value)
            pEncja.parametry = zaladujParametryDoObiektow(pEncja.sekwencja as Sekwencja,pEncja)

        pListaEncji.add(pEncja)

        }
        return pListaEncji.toList()
    }

    fun utworzObiektReguly(aKod:String,aTresc:String):RegulaEncja{
        val pEncja=RegulaEncja(aKod, aTresc)
        regulyDbBean.zapiszRegule(pEncja)
        return pEncja
    }

    fun utworzObiektParametru(aRegulaEncja:RegulaEncja,aNazwa:String,aTyp:String,aWartoscDomyslna:String):ParametrRegulyEncja{
        val pEncja=ParametrRegulyEncja(aNazwa,aTyp,aWartoscDomyslna)
        pEncja.regula=aRegulaEncja
        regulyDbBean.zapiszObiektParametru(pEncja)
        return pEncja
    }

    fun zaladujParametryDoObiektow(aSekwencja: Sekwencja,aRegulaEncja:RegulaEncja): MutableList<ParametrRegulyEncja> {
        var i: Int = 0
        var unikalnySet: MutableSet<String> = linkedSetOf()

        aSekwencja.rozpoznaneTokeny
                .filter { (it.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU
                        || it.typ == RodzajTokenaEnum.PRAWOSTRONNY_OPERAND_WARUNKU)
                        && !unikalnySet.contains(it.wartosc) }
                .forEach() {
                    unikalnySet.add(it.wartosc)
                    ParametrRegulyEncja(it.wartosc)
                }
        val obiektyParametrow:MutableList<ParametrRegulyEncja> = mutableListOf<ParametrRegulyEncja>()

        unikalnySet.forEach{
            var pEncja=regulyDbBean.pobierzParametrPoNazwie(aRegulaEncja,it)
            if(pEncja==null){
                pEncja=utworzObiektParametru(aRegulaEncja,it,wnioskujTypParametru(it)!!,wnioskujWartoscDomyslnaParametru(it)!!)
            }
            obiektyParametrow.add(pEncja)
        }

     return obiektyParametrow

    }

    fun wnioskujTypParametru(aParam:String):String?{
        return ""
    }

    fun wnioskujWartoscDomyslnaParametru(aParam:String):String?{
        return ""
    }
}