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
    lateinit var fasadaNLP: IFasadaNarzedziaNLP

    //val reguly: MutableMap<String, Regula> = mutableMapOf()

    @PostConstruct
    fun inicjalizuj(): Unit {
        val plistaRegul = String(this::class.java.classLoader.getResourceAsStream("reguly.reg").readBytes()).split("\n")

        val pObiektyDoSynchronizacji: List<Regula> =
                plistaRegul.map({
                    val pRegList = it.split(":")
                    val kodReguly = pRegList[0]
                    val trescRegulyStr = pRegList[1].replace("\r", "")
                    val sekwencja = fasadaNLP.rozpoznajSekwencje(trescRegulyStr)
                    val parametry = wyodrebnijListeParametrow(sekwencja)
                    val wywolania = wyodrebnijListeWywolanInnychRegul(sekwencja, kodReguly)
                    Regula(kodReguly, trescRegulyStr, sekwencja, parametry, wywolania)
                }).toList()

                pObiektyDoSynchronizacji.filter { !it.wywolaniaRegul.isNullOrEmpty() }.map{it.wywolaniaRegul.toList()}.forEach{
                    wyodrebnijParametryWywolania(it,pObiektyDoSynchronizacji)
                }

        synchronizatorDanych.synchronizujDane(pObiektyDoSynchronizacji)
    }
    //**********************************

    @Transactional
    fun podajReguly(): List<Regula> {

        return regulyDbBean.pobierzWszystkieReguly().map {
            konwerter.konwertujDoTransportu(it)
        }.toList()
    }

    @Transactional
    fun zapiszReguly(aReguly: List<Regula>) {
        aReguly.forEach {
            konwerter.konwertujDoEncji(it)
        }
    }

    //**********************************


}


var licznikDefaultowychParametrow = 1
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

    licznikDefaultowychParametrow = 0
    return unikalnySet.map {
        utworzObiektParametru(it, aSekwencja)
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

fun wyodrebnijParametryWywolania(aWywolania:List<WywolanieReguly>,aWszystkieReguly:List<Regula>){
    val mapa=aWszystkieReguly.map { it.kod to it }.toMap()

    aWywolania.forEach{
        val pRegulaWolana:Regula=mapa[it.kodRegulyWolanej]!!
        it.parametry=pRegulaWolana.parametry.map{ParametrWywolaniaReguly(nazwaParametruRegulyWolanej = it.nazwa)}.toMutableList()

    }


}

fun utworzObiektParametru(aNazwaParametru: String, aSekwencja: Sekwencja): Parametr {
    val wraperAtrybutow = wnioskujAtrybutyParametru(aNazwaParametru, aSekwencja)
    return Parametr(wraperAtrybutow.nazwa, wraperAtrybutow.typ, wraperAtrybutow.wartoscDomyslna)
}


fun wnioskujAtrybutyParametru(aParam: String, aSekwencja: Sekwencja): WrapperTypuParametru {
    if (aSekwencja.podajTokenPoWartosci(aParam)!!.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU) {
        return WrapperTypuParametru(aParam)
    } else {
        //prawa strona równania
        if (aParam.contains("'") || aParam.contains("\"")) {
            //string data lub liczba, ale na pewno wartosc domyslne
            if (aParam.replace("\"", "").replace("'", "").trim().matches(formatDaty.toRegex())) {
                return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + licznikDefaultowychParametrow++, "Data", aParam)//wartosc domyslna data

            } else {
                //wartosc domyslna napis
                return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + licznikDefaultowychParametrow++, "Napis", aParam)//wartosc domyslna data
            }
        } else {
            var pEwentualnaLiczba = aParam.trim().toIntOrNull()

            if (pEwentualnaLiczba != null) {
                //wartosc domyslna bedaca liczba
                return WrapperTypuParametru(prefixNazwwyParametruDomyslnego + licznikDefaultowychParametrow++, "Liczba", aParam)//wartosc domyslna data
            }

            //nazwa zmiennej
            return WrapperTypuParametru(aParam)
        }

    }
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