package model.dto

data class Parametr(
        val nazwa: String
        , var typ: String? = null
        , val wartoscDomyslna: String? = ""
) : ObiektBazowy(),IWalidowalny{

    override fun waliduj(): List<String> {
        val bledy:MutableList<String> = mutableListOf<String>()
        if(typ==null){
            bledy.add(zglosBladBrakuOkreslonegoTypu(nazwa))
        }
        return bledy
    }
}