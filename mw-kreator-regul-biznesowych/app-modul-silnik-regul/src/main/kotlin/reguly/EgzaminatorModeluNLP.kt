package reguly

import model.nlp.RodzajTokenaEnum
import model.nlp.RozpoznanyToken
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.file.Path

/*import opennlp.tools.namefind.NameFinderME
import opennlp.tools.util.Span*/
@Component
open class EgzaminatorModeluNLP {

    @Value("\${modelnlp}")
    lateinit var plikModelu: Path

    /*fun rozpoznajSekwencje(aSekwencja:String):Sekwencja{

        val pSekwencja=Sekwencja(aSekwencja,aSekwencja.split(" ".toRegex()).toTypedArray())

        var nameFinderModel=TrenerModeluNLP.podajModel()

        // testing the model and printing the types it found in the input sentence
        val nameFinder = NameFinderME(nameFinderModel)

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
    }*/

}



