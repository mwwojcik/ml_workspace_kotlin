package model.dto

class ParametrWywolaniaReguly( val nazwaParametruRegulyWolajacej:String=""
                              ,val nazwaParametruRegulyWolanej  :String ) : ObiektBazowy(),IWalidowalny {

    override fun waliduj(): List<String> {
        return emptyList()
    }
}