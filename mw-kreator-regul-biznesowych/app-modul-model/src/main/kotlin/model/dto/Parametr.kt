package model.dto

data class Parametr(
        val nazwa: String
        , var typ: String? = null
        , val wartoscDomyslna: String? = ""
) : ObiektBazowy()