package model.nlp

import dnl.utils.text.table.TextTable
import java.lang.IllegalArgumentException


class Sekwencja(val zdaniePierwotne:String, val tokeny:Array<String>,
                val rozpoznaneTokeny:MutableList<RozpoznanyToken>
                = mutableListOf<RozpoznanyToken>()) {

    var postacKanoniczna:String=zdaniePierwotne

    var komunikaty: MutableMap <String,String>? = mutableMapOf()




    fun podajTokenPoLP(lp:Int):RozpoznanyToken=rozpoznaneTokeny[lp-1]


    fun podajTokenPoWartosci(aWartosc:String):RozpoznanyToken?{
        return rozpoznaneTokeny.map{it.wartosc to it}.toMap().get(aWartosc)
    }

    fun podajPierwszyTokenDanegoTypu(aTypTokena:RodzajTokenaEnum):RozpoznanyToken?{
        for(i in 1..rozpoznaneTokeny.size){
            if(podajTokenPoLP(i).typ==aTypTokena){
                return podajTokenPoLP(i)
            }
        }
        return null
    }


    fun podajTokenyCzesciWarunkowejReguly():List<RozpoznanyToken>{
        val tokenyCzescWarunkowa= mutableListOf<RozpoznanyToken>()
        //zaczynamy od 2 bo chcemy przeskoczyc poczatek reguly
        for(i in 2..rozpoznaneTokeny.size){
            if (podajTokenPoLP(i).typ==RodzajTokenaEnum.KONIEC_REGULY){
                break
            }
            tokenyCzescWarunkowa.add(podajTokenPoLP(i))
        }
        return tokenyCzescWarunkowa
    }

    fun podajTokenyAkcjiTak():List<RozpoznanyToken>{
        val tokenyAkcjaTak= mutableListOf<RozpoznanyToken>()
        //zaczynamy od 2 bo chcemy przeskoczyc poczatek reguly
        var indeksStart=podajPierwszyTokenDanegoTypu(RodzajTokenaEnum.KONIEC_REGULY)!!.lp+1
        for( i  in indeksStart..rozpoznaneTokeny.size){
            if (podajTokenPoLP(i).typ==RodzajTokenaEnum.W_PRZECIWNYM_RAZIE){
                break
            }
            tokenyAkcjaTak.add(podajTokenPoLP(i))
        }
        return tokenyAkcjaTak
    }

    fun podajTokenyAkcjiNie():List<RozpoznanyToken>{
        val tokenyAkcjaNie= mutableListOf<RozpoznanyToken>()
        //zaczynamy od 2 bo chcemy przeskoczyc poczatek reguly
        var tokenWPrzeciwnym=podajPierwszyTokenDanegoTypu(RodzajTokenaEnum.W_PRZECIWNYM_RAZIE)
        if(tokenWPrzeciwnym==null){
            return emptyList()
        }
        var indeksStart=tokenWPrzeciwnym.lp+1
        for( i  in indeksStart..rozpoznaneTokeny.size){
            tokenyAkcjaNie.add(podajTokenPoLP(i))
        }
        return tokenyAkcjaNie
    }


    /**
     * **************************************
     * **************************************
     * ********** Tylko dla testów **********
     * **************************************
     */
    fun dajPierwszyOperatorWarunku():String{
        for (tok in rozpoznaneTokeny){
            if (tok.typ==RodzajTokenaEnum.OPETATOR_POROWNANIA||tok.typ==RodzajTokenaEnum.OPERATOR_POROWNANIA_NULL){
                return tok.wartosc.trim();
            }
        }

        throw IllegalArgumentException("Brak rozpoznanego warunku")
    }

    fun drukuj(){

        println("\n\nZDANIE=>"+zdaniePierwotne)
        val pDane= mutableListOf<Array<String>>()
        for(pTok in rozpoznaneTokeny){
            pDane.add(arrayOf<String>(pTok.wartosc,pTok.typ.toString(),pTok.prob.toString()))
        }
        val col= arrayOf("Fraza","Typ","Prawdopodobienstwo")
        val data= pDane.toTypedArray()

        val tt = TextTable(col, data)

        tt.printTable()
    }


}