package model.akcje

class WyswietlenieKomunikatuAkcja(val komunikat:String):IAkcja {
    private val nazwaMetody="wyswietlKomunikat"
    override fun podajAkcje(): String {
        return nazwaMetody+"("+komunikat+")"
    }
}