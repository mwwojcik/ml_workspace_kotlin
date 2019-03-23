package model.nlp

import java.lang.StringBuilder
import dnl.utils.text.table.TextTable
import java.lang.IllegalArgumentException


class Sekwencja(val wartosc:String, val tokeny:Array<String>,
                val rozpoznaneTokeny:MutableList<RozpoznanyToken>
                = mutableListOf<RozpoznanyToken>()) {


    fun drukuj(){

        println("\n\nZDANIE=>"+wartosc)
        val pDane= mutableListOf<Array<String>>()
        for(pTok in rozpoznaneTokeny){
            pDane.add(arrayOf<String>(pTok.wartosc,pTok.typ.toString(),pTok.prob.toString()))
        }
        val col= arrayOf("Fraza","Typ","Prawdopodobienstwo")
        val data= pDane.toTypedArray()

        val tt = TextTable(col, data)

        tt.printTable()
    }

    fun dajPierwszyOperatorWarunku():String{
        for (tok in rozpoznaneTokeny){
            if (tok.typ==RodzajTokenaEnum.OPETATOR_POROWNANIA){
                return tok.wartosc.trim();
            }
        }

        throw IllegalArgumentException("Brak rozpoznanego warunku")
    }
}