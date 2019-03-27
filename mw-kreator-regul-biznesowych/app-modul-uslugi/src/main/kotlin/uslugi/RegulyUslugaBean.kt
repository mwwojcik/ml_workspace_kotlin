package uslugi

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
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

    var listaRegul= mutableListOf<String>()

    @Autowired
    lateinit var egzaminator: EgzaminatorModeluRozpoznawaniaEncjiNLP

    @PostConstruct
    fun inicjalizuj() {
        val plistaRegul = String(this::class.java.classLoader.getResourceAsStream("reguly.reg").readBytes()).split("\n")
        listaRegul.addAll(plistaRegul)
    }

    fun podajReguly():List<Sekwencja> {

        var listaSekwencji:MutableList<Sekwencja> =listaRegul.map{egzaminator.rozpoznajSekwencje(it)}.toMutableList()
        return listaSekwencji
        /*for (s:String in listaRegul){
            egzaminator.rozpoznajSekwencje(s).drukuj()
        }

        regulyDbBean.znajdzWszystkieReguly()*/
    }
}