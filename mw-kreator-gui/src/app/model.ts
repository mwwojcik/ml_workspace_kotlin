

/**
 * 
 
 
open  class ObiektBazowy(){
    var id:Long?=null
    var wersja:Long?=null
}

data class Parametr(
        val nazwa: String
        , var typ: String? = null
        , val wartoscDomyslna: String? = ""
        , val czyUsuwalny:Int=0
) : ObiektBazowy(),IWalidowalny{}

class ParametrWywolaniaReguly( var nazwaParametruRegulyWolajacej:String=""
                              ,var nazwaParametruRegulyWolanej  :String )

                              {}

   data class Regula(
        val kod: String
        , var tresc: String
        , val sekwencja: Sekwencja
        , var parametry: MutableList<Parametr> = mutableListOf()
        , var wywolaniaRegul: MutableList<WywolanieReguly> = mutableListOf()
    )                           
class WywolanieReguly(val kodRegulyWolajacej: String
                      , val kodRegulyWolanej: String
                      , var parametry: MutableList<ParametrWywolaniaReguly> = mutableListOf()
)
 */
export class RegulaBiznesowa {
    kod: string;
}
