package model.dto

class ParametrWywolaniaReguly(val wywolanie:WywolanieReguly
                              , val parametrRegulyWolajacej:Parametr
                              ,val parametrRegulyWolanej:Parametr ) : ObiektBazowy(),IWalidowalny {

    override fun waliduj(): List<String> {
        return emptyList()
    }
}