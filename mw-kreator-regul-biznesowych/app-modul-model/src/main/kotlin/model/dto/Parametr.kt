package model.dto

data class Parametr(
        val nazwa: String
        , var typ: String? = null
        , val wartoscDomyslna: String? = ""
        , val czyUsuwalny:Int=0
) : ObiektBazowy(),IWalidowalny{

    override fun waliduj(): List<String> {
        val bledy:MutableList<String> = mutableListOf<String>()
        if(typ==null){
            bledy.add(zglosBladBrakuOkreslonegoTypu(nazwa))
        }
        return bledy
    }
}