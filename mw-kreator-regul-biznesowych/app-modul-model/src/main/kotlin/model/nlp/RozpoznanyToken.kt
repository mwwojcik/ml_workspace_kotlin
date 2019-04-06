package model.nlp

class RozpoznanyToken(val wartosc:String,val typ:RodzajTokenaEnum,val prob:Double) {

    var kategoria:String?=null

    override fun toString(): String {
        return wartosc+"=>"+typ+"("+prob+")"
    }
}