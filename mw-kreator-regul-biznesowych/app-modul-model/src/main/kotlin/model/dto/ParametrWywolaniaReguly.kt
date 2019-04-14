package model.dto

class ParametrWywolaniaReguly( var nazwaParametruRegulyWolajacej:String=""
                              ,var nazwaParametruRegulyWolanej  :String ) : ObiektBazowy(),IWalidowalny {

    override fun waliduj(): List<String> {
        val bledy:MutableList<String> = mutableListOf<String>()

        if(nazwaParametruRegulyWolajacej==null||nazwaParametruRegulyWolajacej.isEmpty()){
            bledy.add(zglosBladBrakuMapowaniaParametruWy(nazwaParametruRegulyWolanej))
        }
        return bledy

    }
}