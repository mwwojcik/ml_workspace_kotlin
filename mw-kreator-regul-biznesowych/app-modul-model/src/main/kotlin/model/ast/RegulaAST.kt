package model.ast

class RegulaAST {
    //nigdy razem
    lateinit var warunek:WyrazenieWarunkoweAST
    //warunki zawsze pierwszenstwo
    lateinit var warunkiLogiczne:List<WyrazenieLogiczneAST>


    lateinit var akcjaTAK:AkcjaAST
    var akcjaNie:AkcjaAST?=null
}