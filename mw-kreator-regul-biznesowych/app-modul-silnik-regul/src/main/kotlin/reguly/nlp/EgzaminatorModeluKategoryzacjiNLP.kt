package reguly.nlp

import opennlp.tools.doccat.DoccatModel
import opennlp.tools.doccat.DocumentCategorizerME
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileInputStream
import javax.annotation.PostConstruct

@Component
open class EgzaminatorModeluKategoryzacjiNLP {
    @Value("\${modelnlp_kategoryzacja}")
    lateinit var plikModelu: String

    lateinit var model: DoccatModel

    @PostConstruct
    public fun inicjujModel(){
        model=odczytajModel()
    }

    private fun odczytajModel(): DoccatModel {
        lateinit var modelNLP: DoccatModel
        try {

            //this.javaClass.classLoader.getResourceAsStream(plikModelu)
            //FileInputStream(plikModelu)
            this.javaClass.classLoader.getResourceAsStream(plikModelu).use { modelIn ->
                modelNLP = DoccatModel(modelIn)
                //println("Trained model read from location=>"+ plikModelu.toAbsolutePath().toString())
                return modelNLP
            }
        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }
    }

    fun wybierzNajlepszaKategorie(text: String): String {
        val documentCategorizerME= DocumentCategorizerME(model);
        val outcomes = documentCategorizerME.categorize(text.split(" ").toTypedArray())
        return documentCategorizerME.getBestCategory(outcomes)
    }
}