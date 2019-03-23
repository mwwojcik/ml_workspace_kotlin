package model.nlp

import java.lang.IllegalArgumentException

enum class RodzajTokenaEnum(val kod:String) {

    POCZATEK_REGULY("regula_start"),
    KONIEC_REGULY("regula_stop"),
    LEWOSTRONNY_OPERAND_WARUNKU("porowanie_OL"),
    PRAWOSTRONNY_OPERAND_WARUNKU("porowanie_OP"),
    OPETATOR_POROWNANIA("operator_porownania"),
    AKCJA("akcja"),
    PARAMETR_AKCJI("parametr_akcji");

    fun podajEnumPoKodzie(aKod:String):RodzajTokenaEnum{
        for(wart:RodzajTokenaEnum in RodzajTokenaEnum.values()){
            if(wart.kod.equals(aKod)) {
                return wart
            }
        }
        throw IllegalArgumentException("Nierozpoznany rodzaj tokena !")
    }
}