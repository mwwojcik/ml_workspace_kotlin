package generator.antlr

import java.time.LocalDate
import kotlin.Int
import kotlin.String

fun wyswietlKomunikat(komunikat: String) {
    println("""$komunikat""")
}

/**
 * r=> JESLI( ((data > dataDo) || (data < dataOd)) || ((data == dataOd) || (data == dataDo)) &&
        (dataDo == dataOd)) wtedy WYSWIETL( " Nieprawidlowa wartosc dat ")
 */
fun sprawdzCzyDatawPrzedziale(
    dataOd: LocalDate,
    dataDo: LocalDate,
    data: LocalDate
) {
    if(((data > dataDo) || (data < dataOd)) || ((data == dataOd) || (data == dataDo)) && (dataDo ==
            dataOd)) {
        wyswietlKomunikat(" Nieprawidlowa wartosc dat ")
    }
}

/**
 * r=> JESLI( (wiek < 18)) wtedy WYSWIETL( " U ytkownik musi byc pelnoletni ") W_PRZECIWNYM_WYPADKU
        SPRAWDZ_REGULE( sprawdzCzyUrodzonyWpierwszymKwartale( miesiac_urodzenia))
 */
fun sprawdzWiek(wiek: Int, miesiac_urodzenia: Int) {
    if((wiek < 18)) {
        wyswietlKomunikat(" U ytkownik musi byc pelnoletni ")
    }
    else {
        sprawdzCzyUrodzonyWpierwszymKwartale(miesiac_urodzenia)
    }
}

/**
 * r=> JESLI( kwartal == 2) wtedy WYSWIETL( " Drugi kwartal roku ") W_PRZECIWNYM_WYPADKU WYSWIETL( "
        To nie jest drugi kwartal ")
 */
fun sprawdzCzyDrugiKwartal(kwartal: Int) {
    if(kwartal == 2) {
        wyswietlKomunikat(" Drugi kwartal roku ")
    }
    else {
        wyswietlKomunikat(" To nie jest drugi kwartal ")
    }
}

/**
 * r=> JESLI( miesiac > 3) wtedy WYSWIETL( " Miesiac spoza pierwszego kwartalu ")
        W_PRZECIWNYM_WYPADKU WYSWIETL( " Miesiac z pierwszego kwartalu ")
 */
fun sprawdzCzyUrodzonyWpierwszymKwartale(miesiac: Int) {
    if(miesiac > 3) {
        wyswietlKomunikat(" Miesiac spoza pierwszego kwartalu ")
    }
    else {
        wyswietlKomunikat(" Miesiac z pierwszego kwartalu ")
    }
}

/**
 * r=> JESLI( rok > 1990 || rok < 1980) wtedy WYSWIETL( " Rok spoza dozwolonego przedzialu ")
        W_PRZECIWNYM_WYPADKU SPRAWDZ_REGULE( sprawdzCzyUrodzonyWpierwszymKwartale( miesiac))
 */
fun sprawdzCzyUrodzonyPrzedRokiem1990iCzyWpierwszymKwartale(rok: Int, miesiac: Int) {
    if(rok > 1990 || rok < 1980) {
        wyswietlKomunikat(" Rok spoza dozwolonego przedzialu ")
    }
    else {
        sprawdzCzyUrodzonyWpierwszymKwartale(miesiac)
    }
}
