package model.nlp

import java.lang.IllegalArgumentException

enum class RodzajTokenaEnum(val kod:String) {

    SK_SW("SK_SW"), //slowo kluczowe-start warunku
    SK_KW("SK_KW"), //slowo kluczowe-koniec warunku
    OP_L("OP_L"),
    OP_P("OP_P"),
    OPR_REL("OPR_REL"),
    AKCJA("AKCJA"),
    AKCJA_PARAMETR("AKCJA_PARAMETR"),
    OPR_LOG("OPR_LOG"),
    SK_SAN("SK_SAN"), //slowo kluczowe - start akcja NIE
    LEWOSTRONNY_OPERAND_POROWNANIA_NULL("porowanie_czy_null_OP"),
    OPERATOR_POROWNANIA_NULL("operator_porownania_czy_null");

    fun podajEnumPoKodzie(aKod:String):RodzajTokenaEnum{
        for(wart:RodzajTokenaEnum in RodzajTokenaEnum.values()){
            if(wart.kod.equals(aKod)) {
                return wart
            }
        }
        throw IllegalArgumentException("Nierozpoznany rodzaj tokena !")
    }
}