package model.dto

class WywolanieReguly(val regulaWolajaca: Regula
                      , val regulaWolana: Regula
                      , var parametry: MutableList<ParametrWywolaniaReguly> = mutableListOf()
) : ObiektBazowy(), IWalidowalny {
    override fun waliduj(): List<String> {
        return emptyList()
    }


}