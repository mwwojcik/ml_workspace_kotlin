package reguly.antlr.analizator

import reguly.antlr.konstruktory.BudowniczyAkcji
import reguly.antlr.konstruktory.BudowniczyInstrukcjiWarunkowej
import reguly.antlr.konstruktory.BudowniczyRegulyBiznesowej
import reguly.antlr.konstruktory.FabrykaAkcji
import model.RegulaBiznesowa
import reguly.antlr.gen.RegulyBiznesoweParser
import reguly.antlr.analizator.BazowyWizytorRegulBiznesowych
import java.lang.IllegalArgumentException
import kotlin.String

class WizytorDlaGrupyRegulBiznesowych : BazowyWizytorRegulBiznesowych<String>() {

    val reguly = mutableListOf<RegulaBiznesowa>()

    override fun visitGrupa_regul(ctx: RegulyBiznesoweParser.Grupa_regulContext): String {
        return super.visitGrupa_regul(ctx)
    }

    override fun visitRegula(ctx: RegulyBiznesoweParser.RegulaContext): String {
        BudowniczyRegulyBiznesowej.inicjuj()
        val pStr = super.visitRegula(ctx)
        reguly.add(BudowniczyRegulyBiznesowej.buduj())
        return pStr
    }

    override fun visitNazwa_reguly(ctx: RegulyBiznesoweParser.Nazwa_regulyContext): String {
        BudowniczyRegulyBiznesowej.dodajNazwe(ctx.nazwa().text)
        return ctx.nazwa().text//super.visitNazwa_reguly(ctx)
    }

    override fun visitParametry_reguly(ctx: RegulyBiznesoweParser.Parametry_regulyContext): String {

        return super.visitParametry_reguly(ctx)
    }

    override fun visitTresc_reguly(ctx: RegulyBiznesoweParser.Tresc_regulyContext): String {
        BudowniczyInstrukcjiWarunkowej.inicjuj()
        val pStr = super.visitTresc_reguly(ctx)
        BudowniczyRegulyBiznesowej.dodajKomentarz(pStr)
       BudowniczyRegulyBiznesowej.dodajInstrukcjeWarunkowa(BudowniczyInstrukcjiWarunkowej.buduj())
        return pStr
    }

    override fun visitZlozone_wyrazenie_logiczne(ctx: RegulyBiznesoweParser.Zlozone_wyrazenie_logiczneContext): String {
        return super.visitZlozone_wyrazenie_logiczne(ctx)
    }

    override fun visitWyrazenie_logiczne(ctx: RegulyBiznesoweParser.Wyrazenie_logiczneContext): String {
        return super.visitWyrazenie_logiczne(ctx)
    }

    override fun visitWarunek(ctx: RegulyBiznesoweParser.WarunekContext): String {
        val pStr = super.visitWarunek(ctx)
        return pStr
    }

    override fun visitParametr(ctx: RegulyBiznesoweParser.ParametrContext): String {
        BudowniczyRegulyBiznesowej.dodajParametr(visitNazwa(ctx.nazwa()), visitTyp(ctx.typ()))
        return super.visitParametr(ctx)
    }

    override fun visitTyp(ctx: RegulyBiznesoweParser.TypContext): String {
        when (ctx.text.toUpperCase()) {
            "LICZBA" -> return "Int"
            "DATA" -> return "LocalDate"
            else -> throw IllegalArgumentException("Nierozpoznany typ")

        }
    }

    override fun visitNazwa(ctx: RegulyBiznesoweParser.NazwaContext): String {
        return ctx.text
    }

    override fun visitAkcja(ctx: RegulyBiznesoweParser.AkcjaContext): String {
        val pStr = super.visitAkcja(ctx)

        /*  if(ctx.nazwa_akcji().akcja_wyswietl_komunikat()!=null){
              BudowniczyAkcji.dodajAkcje(FabrykaAkcji.budujAkcjeWyswietleniaKomunikatu(visitParametr_akcji(ctx.parametr_akcji())))
          }*/

        return pStr
    }

    override fun visitAkcja_warunek_spelniony(ctx: RegulyBiznesoweParser.Akcja_warunek_spelnionyContext?): String {
        BudowniczyAkcji.inicjuj()
        val pStr = super.visitAkcja_warunek_spelniony(ctx)
        BudowniczyInstrukcjiWarunkowej.dodajAkcjeTak(BudowniczyAkcji.buduj())
        return pStr
    }

    override fun visitAkcja_w_przeciwnym_wypadku(ctx: RegulyBiznesoweParser.Akcja_w_przeciwnym_wypadkuContext?): String {
        BudowniczyAkcji.inicjuj()
        val pStr = super.visitAkcja_w_przeciwnym_wypadku(ctx)
        BudowniczyInstrukcjiWarunkowej.dodajAkcjeNie(BudowniczyAkcji.buduj())
        return pStr
    }


    override fun visitAkcja_wyswietl_komunikat(ctx: RegulyBiznesoweParser.Akcja_wyswietl_komunikatContext): String {
        BudowniczyAkcji.dodajAkcje(FabrykaAkcji.budujAkcjeWyswietleniaKomunikatu(visitParametr_akcji(ctx.parametr_akcji())))
        return super.visitAkcja_wyswietl_komunikat(ctx)
    }

    override fun visitParametr_akcji(ctx: RegulyBiznesoweParser.Parametr_akcjiContext): String {
        return super.visitParametr_akcji(ctx)
    }

    override fun visitTekst_wielowyrazowy(ctx: RegulyBiznesoweParser.Tekst_wielowyrazowyContext): String {
        return super.visitTekst_wielowyrazowy(ctx)
    }

    override fun visitWarunek_reguly(ctx: RegulyBiznesoweParser.Warunek_regulyContext?): String {
        // BudowniczyRegulyBiznesowej.dodajWarunek(super.visitWarunek_reguly(ctx))
        var pStr = super.visitWarunek_reguly(ctx)
        BudowniczyInstrukcjiWarunkowej.dodajWarunek(pStr)
        return pStr
    }

    override fun visitOperator_logiczny(ctx: RegulyBiznesoweParser.Operator_logicznyContext): String {
        when (ctx.text.toUpperCase()) {
            "ORAZ" -> return "&&"
            "LUB" -> return "||"
            else -> throw IllegalArgumentException("Nierozpoznany operator logiczny!")
        }

        //return super.visitOperator_logiczny(ctx)
    }


    override fun visitAkcja_sprawdz_regule(ctx: RegulyBiznesoweParser.Akcja_sprawdz_reguleContext): String {

        return super.visitAkcja_sprawdz_regule(ctx)
    }

    override fun visitParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(ctx: RegulyBiznesoweParser.Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext): String {

        BudowniczyAkcji.dodajAkcje(FabrykaAkcji.budujAkcjeWywolaniaReguly(ctx.nazwa().text,
                visitParametry_podawane_do_innej_reguly(ctx.parametry_podawane_do_innej_reguly())))

        return super.visitParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(ctx)
    }

    override fun visitParametry_podawane_do_innej_reguly(ctx: RegulyBiznesoweParser.Parametry_podawane_do_innej_regulyContext?): String {
        return super.visitParametry_podawane_do_innej_reguly(ctx)
    }
}