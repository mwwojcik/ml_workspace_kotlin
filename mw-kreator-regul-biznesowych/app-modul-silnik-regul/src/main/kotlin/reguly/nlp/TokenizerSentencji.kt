package reguly.nlp

import org.springframework.stereotype.Component

@Component
class TokenizerSentencji {

    fun przygotujZdanieDoAnalizy(aZdanie:String):String{
        return aZdanie.replace(",".toRegex()," ").replace("\\.".toRegex()," .").replace("\r".toRegex(),"").replace("\\s+".toRegex()," ")
    }

}