package uslugi

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import javax.annotation.PostConstruct

@Service
open class RegulyUslugaBean {
    @Autowired
    lateinit var regulyDbBean: RegulyDbBean


    @Autowired
    lateinit var egzaminator: EgzaminatorModeluRozpoznawaniaEncjiNLP

    lateinit var listaRegulEncji: MutableList<RegulaEncja>

    @PostConstruct
    fun inicjalizuj(): Unit {
        val plistaRegul = String(this::class.java.classLoader.getResourceAsStream("reguly.reg").readBytes()).split("\n")

        var i: Int = 0;

        listaRegulEncji = plistaRegul.map({ aRegStr: String ->
            val pRegList = aRegStr.split(":")
            RegulaEncja(i++, pRegList[0], pRegList[1])
        }).toMutableList()

        listaRegulEncji.forEach {
            it.sekwencja = egzaminator.rozpoznajSekwencje(it.tresc)
            it.parametry = podajListeParametrow(it.sekwencja as Sekwencja)
        }
    }

    fun podajListeParametrow(aSekwencja: Sekwencja): MutableList<ParametrRegulyEncja> {
        var i: Int = 0
        var unikalnySet: MutableSet<String> = mutableSetOf()
        return aSekwencja.rozpoznaneTokeny
                .filter { (it.typ == RodzajTokenaEnum.LEWOSTRONNY_OPERAND_WARUNKU || it.typ == RodzajTokenaEnum.PRAWOSTRONNY_OPERAND_WARUNKU) && !unikalnySet.contains(it.wartosc) }
                .map {
                    unikalnySet.add(it.wartosc)
                    ParametrRegulyEncja(i++, it.wartosc)
                }
                .toMutableList()
    }

    fun podajReguly(): List<RegulaEncja> {

        //listaRegulEncji.forEach { it.sekwencja!!.drukuj() }
        return listaRegulEncji
    }
}