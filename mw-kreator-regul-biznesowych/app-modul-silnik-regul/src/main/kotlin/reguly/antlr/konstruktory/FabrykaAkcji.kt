package reguly.antlr.konstruktory

import model.antlr.akcje.IAkcja
import model.antlr.akcje.WyswietlenieKomunikatuAkcja
import model.antlr.akcje.WywolanieRegulyAkcja

object FabrykaAkcji {
    fun budujAkcjeWyswietleniaKomunikatu(komunikat:String): IAkcja {
        return WyswietlenieKomunikatuAkcja(komunikat)
    }

    fun budujAkcjeWywolaniaReguly(nazwaReguly:String,parametry:String): IAkcja {
        return WywolanieRegulyAkcja(nazwaReguly, parametry)
    }
}