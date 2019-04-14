package model.ast

class RegulaAST {
    //nigdy razem
    lateinit var warunek:WyrazenieWarukoweAST
    //warunki zawsze pierwszenstwo
    lateinit var warunkiLogiczne:List<WyrazenieLogiczneAST>


    lateinit var akcjaTAK:IAkcjaAST
    var akcjaNie:IAkcjaAST?=null
}