package model.wyrazenia

import model.akcje.IAkcja

class WyrazenieWarunkowe() : IWyrazenie {
    lateinit var warunek: String
    lateinit var akcjaTak: IAkcja
    var akcjaNie: IAkcja? = null
}