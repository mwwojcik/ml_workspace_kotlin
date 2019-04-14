package reguly.antlr.konstruktory

import model.antlr.akcje.IAkcja
import model.antlr.wyrazenia.WyrazenieWarunkowe

object BudowniczyInstrukcjiWarunkowej: IBudowniczy<WyrazenieWarunkowe> {
    private lateinit var instrukcja: WyrazenieWarunkowe

    override fun inicjuj() {
        instrukcja = WyrazenieWarunkowe()
    }

    fun dodajWarunek(warunek:String){
        instrukcja.warunek=warunek
    }

    fun dodajAkcjeTak(aAkcjaTak: IAkcja){
        instrukcja.akcjaTak=aAkcjaTak
    }
    fun dodajAkcjeNie(aAkcjaNie: IAkcja){
        instrukcja.akcjaNie=aAkcjaNie
    }

    override fun buduj(): WyrazenieWarunkowe {
       return instrukcja
    }
}