package model.dto

class ParametrWywolaniaReguly( var nazwaParametruRegulyWolajacej:String=""
                              ,var nazwaParametruRegulyWolanej  :String ) : ObiektBazowy(),IWalidowalny {

    override fun waliduj(): List<String> {
        return emptyList()
    }
}