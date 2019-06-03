package model.dto

class WywolanieReguly(val kodRegulyWolajacej: String
                      , val kodRegulyWolanej: String
                      , var parametry: MutableList<ParametrWywolaniaReguly> = mutableListOf()
) : ObiektBazowy(), IWalidowalny {

    var nazwyParametrowRegulyWolajacej:List<String>?=null

    override fun waliduj(): List<String> {
        val bledy: MutableList<String> = mutableListOf<String>()

        parametry.forEach {
            bledy.addAll(it.waliduj())
        }
        return bledy
    }


}