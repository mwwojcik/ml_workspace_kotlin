package model.nlp

class RozpoznanyToken(val wartosc:String,val typ:RodzajTokenaEnum,val prob:Double) {

    override fun toString(): String {
        return wartosc+"=>"+typ+"("+prob+")"
    }
}