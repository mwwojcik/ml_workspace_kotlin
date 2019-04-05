package reguly.nlp

import model.nlp.RodzajTokenaEnum
import model.nlp.RozpoznanyToken
import model.nlp.Sekwencja
import opennlp.tools.namefind.NameFinderME
import opennlp.tools.namefind.TokenNameFinderModel
import opennlp.tools.util.Span
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileInputStream
import java.nio.file.Path
import javax.annotation.PostConstruct

/*import opennlp.tools.namefind.NameFinderME
import opennlp.tools.util.Span*/
@Component
open class EgzaminatorModeluRozpoznawaniaEncjiNLP {

    @Value("\${modelnlp}")
    lateinit var plikModelu: String

    lateinit var model:TokenNameFinderModel

    @Autowired
    lateinit var tokenizer:TokenizerSentencji

    @PostConstruct
    public fun inicjujModel(){
        model=odczytajModel()
    }

    private fun odczytajModel(): TokenNameFinderModel {
        lateinit var modelNLP: TokenNameFinderModel
        try {

            this.javaClass.classLoader.getResourceAsStream(plikModelu).use { modelIn ->
                modelNLP = TokenNameFinderModel(modelIn)
                //println("Trained model read from location=>"+ plikModelu.toAbsolutePath().toString())
                return modelNLP
            }
        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }
    }

    public fun rozpoznajSekwencje(aSekwencja:String):Sekwencja{

        val pSekwencja=Sekwencja(aSekwencja,tokenizer.przygotujZdanieDoAnalizy(aSekwencja).split(" ".toRegex()).toTypedArray())

        // testing the model and printing the types it found in the input sentence
        val nameFinder = NameFinderME(model)

        //println("Finding types in the test sentence..")
        val names = nameFinder.find(pSekwencja.tokeny)
        for (name: Span in names){
            var pName=""
            for(i in name.start..name.end-1){
                pName+=pSekwencja.tokeny[i]+" "
            }
            pSekwencja.rozpoznaneTokeny.add(RozpoznanyToken(pName,RodzajTokenaEnum.AKCJA.podajEnumPoKodzie(name.type),name.prob))
        }
        return pSekwencja
    }

}



