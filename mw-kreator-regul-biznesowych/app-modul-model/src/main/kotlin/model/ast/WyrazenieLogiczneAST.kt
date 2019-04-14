package model.ast

class WyrazenieLogiczneAST {
    lateinit var operandLewy : WyrazenieWarukoweAST
    lateinit var operatorLogiczny:String
    lateinit var operandPrawy : WyrazenieWarukoweAST
}