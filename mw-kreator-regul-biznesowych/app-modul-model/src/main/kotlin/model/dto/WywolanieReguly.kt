package model.dto

class WywolanieReguly(  val kodRegulyWolajacej: String
                      , val kodRegulyWolanej: String
                      , var parametry: MutableList<ParametrWywolaniaReguly> = mutableListOf()
) : ObiektBazowy(), IWalidowalny {
    override fun waliduj(): List<String> {
        return emptyList()
    }


}