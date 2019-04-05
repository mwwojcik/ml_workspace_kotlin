package model.dto

import model.dto.Parametr
import model.nlp.Sekwencja

data class Regula(
          val kod: String
        , var tresc: String
        , val sekwencja: Sekwencja
        , var parametry: MutableList<Parametr> = mutableListOf()
) : ObiektBazowy(),IWalidowalny {

    override fun waliduj(): List<String> {
        val bledy: MutableList<String> = mutableListOf<String>()

        if (parametry != null) {
            parametry!!.forEach {
                val wynik=it.waliduj()
                if(!wynik.isEmpty()) {
                    bledy.addAll(wynik)
                }
            }
        }

        return bledy
    }

}