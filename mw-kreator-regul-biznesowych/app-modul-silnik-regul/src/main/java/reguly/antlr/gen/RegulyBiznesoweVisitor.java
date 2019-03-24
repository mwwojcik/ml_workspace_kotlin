// Generated from RegulyBiznesowe.g4 by ANTLR 4.7.2

package reguly.antlr.gen;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegulyBiznesoweParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegulyBiznesoweVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#grupa_regul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrupa_regul(RegulyBiznesoweParser.Grupa_regulContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#regula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegula(RegulyBiznesoweParser.RegulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#nazwa_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNazwa_reguly(RegulyBiznesoweParser.Nazwa_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#parametry_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametry_reguly(RegulyBiznesoweParser.Parametry_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#tresc_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTresc_reguly(RegulyBiznesoweParser.Tresc_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#akcja_warunek_spelniony}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAkcja_warunek_spelniony(RegulyBiznesoweParser.Akcja_warunek_spelnionyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#akcja_w_przeciwnym_wypadku}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAkcja_w_przeciwnym_wypadku(RegulyBiznesoweParser.Akcja_w_przeciwnym_wypadkuContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#warunek_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWarunek_reguly(RegulyBiznesoweParser.Warunek_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#zlozone_wyrazenie_logiczne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitZlozone_wyrazenie_logiczne(RegulyBiznesoweParser.Zlozone_wyrazenie_logiczneContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#wyrazenie_logiczne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWyrazenie_logiczne(RegulyBiznesoweParser.Wyrazenie_logiczneContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#warunek}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWarunek(RegulyBiznesoweParser.WarunekContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#parametr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametr(RegulyBiznesoweParser.ParametrContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#typ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTyp(RegulyBiznesoweParser.TypContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#nazwa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNazwa(RegulyBiznesoweParser.NazwaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#akcja}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAkcja(RegulyBiznesoweParser.AkcjaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#akcja_wyswietl_komunikat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAkcja_wyswietl_komunikat(RegulyBiznesoweParser.Akcja_wyswietl_komunikatContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#akcja_sprawdz_regule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAkcja_sprawdz_regule(RegulyBiznesoweParser.Akcja_sprawdz_reguleContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#parametr_akcji}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametr_akcji(RegulyBiznesoweParser.Parametr_akcjiContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#parametr_akcji_sprawdz_regule_wywolanie_innej_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametr_akcji_sprawdz_regule_wywolanie_innej_reguly(RegulyBiznesoweParser.Parametr_akcji_sprawdz_regule_wywolanie_innej_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#parametry_podawane_do_innej_reguly}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametry_podawane_do_innej_reguly(RegulyBiznesoweParser.Parametry_podawane_do_innej_regulyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#tekst_wielowyrazowy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTekst_wielowyrazowy(RegulyBiznesoweParser.Tekst_wielowyrazowyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RegulyBiznesoweParser#operator_logiczny}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_logiczny(RegulyBiznesoweParser.Operator_logicznyContext ctx);
}