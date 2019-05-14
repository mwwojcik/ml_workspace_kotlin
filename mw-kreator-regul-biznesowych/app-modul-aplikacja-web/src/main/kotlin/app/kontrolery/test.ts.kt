package app.kontrolery

import net.bytebuddy.asm.Advice
import java.time.LocalDate


enum class DecyzjaPrzyAprobacieEnum {
    WYCOFAJ
}

enum class SymboleSwiadczenEnum {
    GRSU
}

enum class SymbolDecyzjiEnum {
    SYMBOL_DECYZJI_SR
}

class AprobataDecyzjiOdmawiajacej(var decyzja: DecyzjaPrzyAprobacieEnum? = null, var dataWplywu: LocalDate? = null, var stanowisko: String? = null)

class DaneDecyzjiOAprobacie(var wniosek: Wniosek?)

class Wniosek(var symbolWniosku: SymbolWniosku? = null, var symbolDecyzji: SymbolDecyzji? = null, var przyczynaOdmowyGRSU: String? = null)

class SymbolWniosku(var id: String? = null)

class SymbolDecyzji(var id: String?)


fun czyscPolaDataStanowisko(daneZadaniaAprobaty: AprobataDecyzjiOdmawiajacej?, daneWniosku: DaneDecyzjiOAprobacie?) {

    if (daneZadaniaAprobaty == null)
        return

    if (daneZadaniaAprobaty.decyzja == DecyzjaPrzyAprobacieEnum.WYCOFAJ) {

        daneZadaniaAprobaty.dataWplywu = null
        daneZadaniaAprobaty.stanowisko = null

        if (daneWniosku?.wniosek?.symbolWniosku?.id == SymboleSwiadczenEnum.GRSU.toString()
                || daneWniosku?.wniosek?.symbolDecyzji?.id == SymbolDecyzjiEnum.SYMBOL_DECYZJI_SR.toString()) {
            daneWniosku.wniosek?.przyczynaOdmowyGRSU = null
        }

    } else {
        daneZadaniaAprobaty.dataWplywu = LocalDate.now()
    }
}


fun main() {
    czyscPolaDataStanowisko(AprobataDecyzjiOdmawiajacej(DecyzjaPrzyAprobacieEnum.WYCOFAJ), DaneDecyzjiOAprobacie(Wniosek(SymbolWniosku(SymboleSwiadczenEnum.GRSU.toString()))))
    println("OK")
}