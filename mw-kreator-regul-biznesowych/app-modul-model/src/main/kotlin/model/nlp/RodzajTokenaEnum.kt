package model.nlp

import java.lang.IllegalArgumentException

enum class RodzajTokenaEnum(val kod:String,val typSlownie:String) {

    SK_SW("SK_SW","Początek warunku"), //slowo kluczowe-start warunku
    SK_KW("SK_KW","Koniec warunku"), //slowo kluczowe-koniec warunku
    OP_L("OP_L","Lewostronny operand porównania"),
    OP_P("OP_P","Prawostronny operand porównania"),
    OPR_REL("OPR_REL","Operator relacyjny"),
    AKCJA("AKCJA","Akcja"),
    AKCJA_PARAMETR("AKCJA_PARAMETR","Parametr akcji"),
    OPR_LOG("OPR_LOG","Operator logiczny"),
    SK_SAN("SK_SAN","Początek akcji NIE"), //slowo kluczowe - start akcja NIE
    LEWOSTRONNY_OPERAND_POROWNANIA_NULL("porowanie_czy_null_OP",""),
    OPERATOR_POROWNANIA_NULL("operator_porownania_czy_null","");

    fun podajEnumPoKodzie(aKod:String):RodzajTokenaEnum{
        for(wart:RodzajTokenaEnum in RodzajTokenaEnum.values()){
            if(wart.kod.equals(aKod)) {
                return wart
            }
        }
        throw IllegalArgumentException("Nierozpoznany rodzaj tokena !")
    }
}