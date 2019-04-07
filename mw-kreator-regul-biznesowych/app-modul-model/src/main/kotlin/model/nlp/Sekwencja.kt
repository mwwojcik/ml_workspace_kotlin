package model.nlp

import java.lang.StringBuilder
import dnl.utils.text.table.TextTable
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.IllegalArgumentException


class Sekwencja(val zdaniePierwotne:String, val tokeny:Array<String>,
                val rozpoznaneTokeny:MutableList<RozpoznanyToken>
                = mutableListOf<RozpoznanyToken>()) {

    var postacKanoniczna:String=zdaniePierwotne

    var komunikaty: MutableMap <String,String>? = mutableMapOf()


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


    fun drukujDoStr():String{

        val pStr=StringBuilder("\n\n")


        for(pTok in rozpoznaneTokeny){
            pStr.append(pTok.wartosc+" ==>> "+pTok.typ.toString())
            pStr.append("\n")
        }

        return pStr.toString()
    }

    fun dajPierwszyOperatorWarunku():String{
        for (tok in rozpoznaneTokeny){
            if (tok.typ==RodzajTokenaEnum.OPETATOR_POROWNANIA){
                return tok.wartosc.trim();
            }
        }

        throw IllegalArgumentException("Brak rozpoznanego warunku")
    }

    fun podajTokenPoWartosci(aWartosc:String):RozpoznanyToken?{
        return rozpoznaneTokeny.map{it.wartosc to it}.toMap().get(aWartosc)
    }
}