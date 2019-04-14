package reguly.antlr.konstruktory

import model.Parametr
import model.RegulaBiznesowa
import model.antlr.wyrazenia.WyrazenieWarunkowe

object BudowniczyRegulyBiznesowej: IBudowniczy<RegulaBiznesowa> {
    private lateinit var regula: RegulaBiznesowa

    override fun inicjuj() {
        regula = RegulaBiznesowa()
    }

    fun dodajNazwe(aNazwa: String) {
        regula.nazwa=aNazwa
    }

    fun dodajKomentarz(aKom:String){
        regula.regulaSurowa=aKom
    }

    fun dodajParametr(aNazwa: String, aTyp: String) {
        regula.parametry.add(Parametr(aNazwa, aTyp))
    }

    fun dodajInstrukcjeWarunkowa(aInstrukcja: WyrazenieWarunkowe){
        regula.instrukcjaWarunkowa=aInstrukcja
    }

    override fun buduj(): RegulaBiznesowa {
        return regula
    }
}