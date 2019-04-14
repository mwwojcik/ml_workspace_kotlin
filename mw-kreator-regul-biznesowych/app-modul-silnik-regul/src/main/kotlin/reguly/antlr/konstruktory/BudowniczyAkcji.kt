package reguly.antlr.konstruktory

import model.antlr.akcje.IAkcja

object BudowniczyAkcji : IBudowniczy<IAkcja> {
    private lateinit var akcja: IAkcja

    fun dodajAkcje(aAkcja: IAkcja){
        akcja =aAkcja
    }

    override fun buduj(): IAkcja {
        return akcja
    }

    override fun inicjuj() {
        //NTD
    }
}