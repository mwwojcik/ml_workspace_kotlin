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

    var licznikDefaultowychParametrow=1
    var prefixNazwwyParametruDomyslnego="param"
    val formatDaty="^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]\$"

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
    //**********************************

    fun podajReguly(): List<RegulaEncja> {
        return zaladujRegulyDoObiektow()
    }

    fun zapiszReguly(aReguly: List<RegulaEncja>) {

        aReguly.filter { it.parametry != null }.forEach {
            it.parametry!!.filter {
                it.typ != null
            }.forEach {
                regulyDbBean.zapiszObiektParametru(it)
            }
        }

    }

    //**********************************


    fun zaladujRegulyDoObiektow(): List<RegulaEncja> {
        val pListaEncji = mutableListOf<RegulaEncja>()

        for ((key, value) in reguly) {
            var pEncja = regulyDbBean.pobierzRegulePoKodzie(key)

            if (pEncja == null) {
                pEncja = utworzObiektReguly(key, value)
            }

            pEncja.sekwencja = egzaminator.rozpoznajSekwencje(value)
            pEncja.parametry = zaladujParametryDoObiektow(pEncja.sekwencja as Sekwencja, pEncja)

            pListaEncji.add(pEncja)

        }
        return pListaEncji.toList()
    }

    fun utworzObiektReguly(aKod: String, aTresc: String): RegulaEncja {
        val pEncja = RegulaEncja(aKod, aTresc)
        regulyDbBean.zapiszRegule(pEncja)
        return pEncja
    }



    fun zaladujParametryDoObiektow(aSekwencja: Sekwencja, aRegulaEncja: RegulaEncja): MutableList<ParametrRegulyEncja> {
        var i: Int = 0
        var unikalnySet: MutableSet<String> = linkedSetOf()

        aSekwencja.rozpoznaneTokeny
                .filter {
                    (it.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU
                            || it.typ == RodzajTokenaEnum.PRAWOSTRONNY_OPERAND_WARUNKU)
                            && !unikalnySet.contains(it.wartosc)
                }
                .forEach() {
                    unikalnySet.add(it.wartosc)
                    ParametrRegulyEncja(it.wartosc)
                }
        val obiektyParametrow: MutableList<ParametrRegulyEncja> = mutableListOf<ParametrRegulyEncja>()

        licznikDefaultowychParametrow=0

        unikalnySet.forEach {
            var pEncja = regulyDbBean.pobierzParametrPoNazwie(aRegulaEncja, it)

            if (pEncja == null) {
                pEncja = utworzObiektParametru(aRegulaEncja, it)
            }

            obiektyParametrow.add(pEncja)
        }

        return obiektyParametrow

    }

    fun utworzObiektParametru(aRegulaEncja: RegulaEncja, aParametr: String): ParametrRegulyEncja {
        val wraperAtrybutow=wnioskujAtrybutyParametru(aParametr,aRegulaEncja)
        val pEncja = ParametrRegulyEncja(wraperAtrybutow.nazwa, wraperAtrybutow.typ, wraperAtrybutow.wartoscDomyslna)
        pEncja.regula = aRegulaEncja
        regulyDbBean.zapiszObiektParametru(pEncja)
        return pEncja
    }


    fun wnioskujAtrybutyParametru(aParam: String,aRegula: RegulaEncja): WrapperTypuParametru {
        if(aRegula.sekwencja!!.podajTokenPoWartosci(aParam)!!.typ==RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU){
            return WrapperTypuParametru(aParam)
        }else{
            //prawa strona równania
            if(aParam.contains("'")||aParam.contains("\"")){
                //string data lub liczba, ale na pewno wartosc domyslne
                if(aParam.replace("\"","").replace("'","").trim().matches(formatDaty.toRegex())){
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego+licznikDefaultowychParametrow++,"Data",aParam)//wartosc domyslna data

                }else {
                    //wartosc domyslna napis
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + licznikDefaultowychParametrow++, "Napis", aParam)//wartosc domyslna data
                }
            }else{
                var pEwentualnaLiczba=aParam.trim().toIntOrNull()

                if(pEwentualnaLiczba!=null){
                    //wartosc domyslna bedaca liczba
                    return WrapperTypuParametru(prefixNazwwyParametruDomyslnego+licznikDefaultowychParametrow++,"Liczba",aParam)//wartosc domyslna data
                }

                //nazwa zmiennej
                return WrapperTypuParametru(aParam)
            }

        }
    }

}

class WrapperTypuParametru(val nazwa:String,val typ:String?=null,val wartoscDomyslna:String?=null){
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