import { extend } from 'webdriver-js-extender';


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


                      class Sekwencja(val zdaniePierwotne:String, val tokeny:Array<String>,
                val rozpoznaneTokeny:MutableList<RozpoznanyToken>
                = mutableListOf<RozpoznanyToken>()) {


                    class RozpoznanyToken(val lp:Int,val wartosc:String,val typ:RodzajTokenaEnum,val prob:Double) {

    var kategoria:String?=null

)
 */
export class ObiektBazowy {
    id: number;
    wersja: number;
}

export class RegulaBiznesowa {
    kod: string;
}

export class Parametr extends ObiektBazowy {
    nazwa: string;
    typ: string;
    wartoscDomyslna: string;
    czyUsuwalny: number = 0;
}

export class ParametrWywolaniaReguly extends ObiektBazowy {
    nazwaParametruRegulyWolajacej: string;
    nazwaParametruRegulyWolanej: string;
}

export class Regula extends ObiektBazowy {
    kod: string
    tresc: string
    sekwencja: Sekwencja;
    parametry: Array<Parametr>;
    wywolaniaRegul: Array<WywolanieReguly>;
}

class Sekwencja {
    zdaniePierwotne: string;
    postacKanoniczna:string;
    tokeny: Array<string>;
    rozpoznaneTokeny: Array<RozpoznanyToken>;
    //komunikaty:Map<string,string>;
}

class RozpoznanyToken {
    lp:number;
    wartosc:string;
    typ:string;
    prob:number;
    kategoria:string;
}

class WywolanieReguly  extends ObiektBazowy{
    kodRegulyWolajacej: string;
    kodRegulyWolanej: string;
    parametry: Array<ParametrWywolaniaReguly>;
}