package model.dto

import model.dto.Parametr
import model.nlp.Sekwencja

data class Regula(
          val kod: String
        , var tresc: String
        , val sekwencja: Sekwencja
        , var parametry: MutableList<Parametr> = mutableListOf()
) : ObiektBazowy() {

}