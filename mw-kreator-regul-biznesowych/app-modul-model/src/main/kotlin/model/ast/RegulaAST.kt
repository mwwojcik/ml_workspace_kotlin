package model.ast

class RegulaAST {
    //nigdy razem
    lateinit var warunek:WyrazenieWarunkoweAST
    //warunki zawsze pierwszenstwo
    lateinit var warunkiLogiczne:List<WyrazenieLogiczneAST>


    lateinit var akcjaTAK:IAkcjaAST
    var akcjaNie:IAkcjaAST?=null
}