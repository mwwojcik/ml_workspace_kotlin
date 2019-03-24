package reguly.antlr.konstruktory

import model.akcje.IAkcja
import model.akcje.WyswietlenieKomunikatuAkcja
import model.akcje.WywolanieRegulyAkcja

object FabrykaAkcji {
    fun budujAkcjeWyswietleniaKomunikatu(komunikat:String):IAkcja{
        return WyswietlenieKomunikatuAkcja(komunikat)
    }

    fun budujAkcjeWywolaniaReguly(nazwaReguly:String,parametry:String):IAkcja{
        return WywolanieRegulyAkcja(nazwaReguly,parametry)
    }
}