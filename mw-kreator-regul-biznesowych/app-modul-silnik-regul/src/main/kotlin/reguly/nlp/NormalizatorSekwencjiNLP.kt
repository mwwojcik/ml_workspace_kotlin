package reguly.nlp

import model.nlp.PostacKanonicznaZdania
import org.springframework.stereotype.Component

@Component
class NormalizatorSekwencjiNLP {

    private fun przygotujZdanieDoAnalizy(aZdanie:String):String{
        return aZdanie.replace(",".toRegex()," ").replace("\\.".toRegex()," .").replace("\r".toRegex(),"").replace("\\s+".toRegex()," ")
    }

    fun zwrocPostacZnormalizowana(aZdanie:String):PostacKanonicznaZdania{
        var pZdanie=przygotujZdanieDoAnalizy(aZdanie)
        val pPostacKanoniczna=PostacKanonicznaZdania(pZdanie)
        wyodrebnijKomunikaty(pPostacKanoniczna)
        return pPostacKanoniczna
    }

    private fun wyodrebnijKomunikaty(aPostacKanoniczna:PostacKanonicznaZdania){
        val pKomunikatyMapa= mutableMapOf<String,String>()


        var nazwaParametru="KOMUNIKAT"

        val pKomunikatyRegex="\".+?\"".toRegex()
        val kolekcjaWynikow = pKomunikatyRegex.findAll(aPostacKanoniczna.postacPierwotna)

        var pZdanieZmodyfikowane=aPostacKanoniczna.postacPierwotna

        for((index,matchRes) in kolekcjaWynikow.withIndex()){
            val pKlucz=nazwaParametru+(index+1)
            pKomunikatyMapa.put(pKlucz,matchRes.value.replace("\"",""))
            pZdanieZmodyfikowane=pZdanieZmodyfikowane.replace(matchRes.value.toRegex(),pKlucz)
        }

        aPostacKanoniczna.postacKanoniczna=pZdanieZmodyfikowane
        aPostacKanoniczna.komunikaty=pKomunikatyMapa

    }
}

//Jeśli data jest większa od '01-01-2019' to wyświetl komunikat %data jest większa% w przeciwnym wypadku wyświetl komunikat %data wcale nie jest większa tylko mniejsza%