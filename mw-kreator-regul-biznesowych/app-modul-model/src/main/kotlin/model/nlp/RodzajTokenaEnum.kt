package model.nlp

import java.lang.IllegalArgumentException

enum class RodzajTokenaEnum(val kod:String) {

    POCZATEK_REGULY("SK_SW"),
    KONIEC_REGULY("SK_KW"),
    LEWOSTRONNY_OPERAND_WARUNKU("OP_L"),
    PRAWOSTRONNY_OPERAND_WARUNKU("OP_P"),
    OPETATOR_POROWNANIA("OPR_REL"),
    AKCJA("AKCJA"),
    PARAMETR_AKCJI("AKCJA_PARAMETR"),
    OPERATOR_LOGICZNY("OPR_LOG"),
    W_PRZECIWNYM_RAZIE("SK_SAN"),
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