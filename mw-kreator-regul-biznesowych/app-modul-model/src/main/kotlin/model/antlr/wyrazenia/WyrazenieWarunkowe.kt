package model.antlr.wyrazenia

import model.antlr.akcje.IAkcja


class WyrazenieWarunkowe() : IWyrazenie {
    lateinit var warunek: String
    lateinit var akcjaTak: IAkcja
    var akcjaNie: IAkcja? = null
}