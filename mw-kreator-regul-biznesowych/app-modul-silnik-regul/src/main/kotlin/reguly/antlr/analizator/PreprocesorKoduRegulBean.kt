package reguly.antlr.analizator

import org.springframework.stereotype.Component

@Component
open class PreprocesorKoduRegulBean {

    val maperKonstrukcji = hashMapOf(
            "wyświetl komunikat" to "WYSWIETL"
            , "w przeciwnym wypadku" to "W_PRZECIWNYM_WYPADKU"
            , "jeśli" to "JESLI"
            , "jesli" to "JESLI"
            , "jezeli" to "JESLI"
            , "JEŻELI" to "JESLI"
            , "sprawdź regułę" to "SPRAWDZ_REGULE")

    fun przetwarzajKodRegul(aKod: String): String {
        var pStr = aKod;
        for ((k, v) in maperKonstrukcji) {
            pStr = pStr.replace(k, v,ignoreCase = true)
        }
        return pStr
    }
}