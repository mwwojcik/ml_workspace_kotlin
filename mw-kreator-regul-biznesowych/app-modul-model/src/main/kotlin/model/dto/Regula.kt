package model.dto

import model.dto.Parametr
import model.nlp.Sekwencja

data class Regula(
        val kod: String
        , var tresc: String
        , val sekwencja: Sekwencja
        , var parametry: MutableList<Parametr>?
        , var wywolaniaRegul: MutableList<WywolanieReguly>?
    ) : ObiektBazowy(), IWalidowalny {


    override fun waliduj(): List<String> {
        val bledy: MutableList<String> = mutableListOf<String>()

        parametry?.forEach {
            bledy.addAll(it.waliduj())
        }

        wywolaniaRegul?.forEach { bledy.addAll(it.waliduj()) }

        return bledy
    }

}