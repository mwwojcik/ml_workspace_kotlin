package generator

import model.ast.AkcjaAST
import model.ast.RegulaAST
import model.ast.WyrazenieLogiczneAST
import model.ast.WyrazenieWarunkoweAST
import model.dto.Parametr
import model.dto.Regula
import model.nlp.RozpoznanyToken
import model.nlp.Sekwencja
import java.lang.IllegalArgumentException


interface IBudowniczyAST<T> {
    fun buduj(): T?

    fun inicjuj(aTokeny: List<RozpoznanyToken>)
}

object BudowniczyRegulyAST : IBudowniczyAST<RegulaAST> {

    lateinit var sekwencja:Sekwencja
    //lateinit var regula: Regula
    lateinit var tokeny:List<RozpoznanyToken>

    override fun buduj(): RegulaAST {
        val reg=RegulaAST()
        //BudowniczyWyrazeniaWarunkowegoAST.parametry= regula.parametry.toList()
        BudowniczyWyrazeniaWarunkowegoAST.inicjuj(sekwencja.podajTokenyWarunkuPodstawowegoReguly())
        BudowniczyWyrazeniaLogicznegoAST.inicjuj(sekwencja.podajTokenyWarunkuLogicznegoReguly())

        reg.warunek= BudowniczyWyrazeniaWarunkowegoAST.buduj()
        reg.warunkiLogiczne= BudowniczyWyrazeniaLogicznegoAST.buduj()

        BudowniczyAkcjiAST.inicjuj(sekwencja.podajTokenyAkcjiTak())
        reg.akcjaTAK= BudowniczyAkcjiAST.buduj()!!

        BudowniczyAkcjiAST.inicjuj(sekwencja.podajTokenyAkcjiNie())
        reg.akcjaNie= BudowniczyAkcjiAST.buduj()

        return reg
    }

    override fun inicjuj(aTokeny: List<RozpoznanyToken>) {
        tokeny = aTokeny
    }
}




object BudowniczyWyrazeniaWarunkowegoAST : IBudowniczyAST<WyrazenieWarunkoweAST> {
    lateinit var tokeny:List<RozpoznanyToken>
   // lateinit var parametry:List<Parametr>
    override fun buduj(): WyrazenieWarunkoweAST {
        val pWarunek=WyrazenieWarunkoweAST()


        pWarunek.operandLewy= tokeny[0].wartosc
        pWarunek.operatorWarunku= tokeny[1].kategoria!!
        pWarunek.operandPrawy= tokeny[2].wartosc

        return pWarunek
    }

    override fun inicjuj(aTokeny: List<RozpoznanyToken>) {
        tokeny = aTokeny
    }

  /*  fun przemapujWartoscDomyslnaNaParametr(aKlucz:String):String{
        val pMapa:Map<String,String> = parametry.filter { it.wartoscDomyslna!=null }.map { it.wartoscDomyslna!! to it.nazwa!! }.toMap()

        if(pMapa.containsKey(aKlucz)){
            return pMapa[aKlucz]!!
        }else{
            return aKlucz
        }
    }*/
}


object BudowniczyWyrazeniaLogicznegoAST : IBudowniczyAST<List<WyrazenieLogiczneAST>> {

    lateinit var tokeny:List<RozpoznanyToken>

    override fun buduj(): List<WyrazenieLogiczneAST> {

        if(tokeny.isEmpty()){
            return emptyList()
        }

        if(tokeny.size%4!=0){
            throw IllegalArgumentException("Nieprawidlowa liczba tokenow warunkow logicznych reguly.")
        }

        val listaWarunkowLogicznych:MutableList<WyrazenieLogiczneAST> = mutableListOf<WyrazenieLogiczneAST>()


        for(i in 0..tokeny.size-4 step 4){
            val operator= tokeny[i]
            BudowniczyWyrazeniaWarunkowegoAST.inicjuj(listOf(tokeny[i + 1], tokeny[i + 2], tokeny[i + 3]))

            val pWarunekLogiczny=WyrazenieLogiczneAST()
            pWarunekLogiczny.operatorLogiczny=operator.kategoria!!
            pWarunekLogiczny.operandPrawy= BudowniczyWyrazeniaWarunkowegoAST.buduj()

            listaWarunkowLogicznych.add(pWarunekLogiczny)

        }

        return listaWarunkowLogicznych.toList()
    }


    override fun inicjuj(aTokeny: List<RozpoznanyToken>) {
        tokeny = aTokeny
    }
}

object BudowniczyAkcjiAST : IBudowniczyAST<AkcjaAST> {
    lateinit var tokeny:List<RozpoznanyToken>
    override fun buduj(): AkcjaAST? {
        if(tokeny.isEmpty()){
            return null
        }
        if(tokeny.size!=2){
            throw IllegalArgumentException("Nieprawidlowa liczba tokenow akcji.")
        }
        val akcja=AkcjaAST()
        akcja.akcja= tokeny[0].kategoria!!
        akcja.parametr= tokeny[1].wartosc

        return akcja
    }

    override fun inicjuj(aTokeny: List<RozpoznanyToken>) {
        tokeny = aTokeny
    }
}
