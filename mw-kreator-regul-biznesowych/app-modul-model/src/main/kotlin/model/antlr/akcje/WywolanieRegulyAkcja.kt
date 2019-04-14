package model.antlr.akcje

class WywolanieRegulyAkcja(val nazwaReguly:String,val parametry:String) : IAkcja {
    override fun podajAkcje(): String {
        return nazwaReguly+"("+parametry+")"
    }
}