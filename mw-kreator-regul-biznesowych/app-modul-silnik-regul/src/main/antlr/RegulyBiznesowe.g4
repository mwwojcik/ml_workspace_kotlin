grammar RegulyBiznesowe;

@parser::header {
package reguly.antlr.gen;

}
@lexer::header {
package reguly.antlr.gen;
}

grupa_regul
    :   regula (regula)* EOF
    ;

regula
    :'{'
     nazwa_reguly
     parametry_reguly
     tresc_reguly
     '}';

nazwa_reguly:
    'n=>'nazwa
;

parametry_reguly
    :'p=>'  parametr (','parametr)*
;



tresc_reguly
    :'r=>'LITERAL_JESLI NO warunek_reguly  NZ LITERAL_WTEDY akcja_warunek_spelniony (LITERAL_W_PRZECIWNYM_WYPADKU akcja_w_przeciwnym_wypadku)?
;

akcja_warunek_spelniony
    :(akcja)
    ;

akcja_w_przeciwnym_wypadku
    :(akcja)
    ;

warunek_reguly
: zlozone_wyrazenie_logiczne (operator_logiczny zlozone_wyrazenie_logiczne)*
;

zlozone_wyrazenie_logiczne
    :(wyrazenie_logiczne|warunek) ((operator_logiczny) (wyrazenie_logiczne|warunek))*
    ;

wyrazenie_logiczne
    : NO? warunek (operator_logiczny) warunek NZ?
    ;

warunek
    : NO? nazwa OPERATOR_POROWNANIA (NUMERIC_VALUE|nazwa|INT) NZ?
    ;

parametr
    :   nazwa '('typ')'
    ;

typ
    :   IDENTIFIER
    ;

nazwa
    :   IDENTIFIER
    ;
akcja
    : (akcja_wyswietl_komunikat|akcja_sprawdz_regule)
    ;

akcja_wyswietl_komunikat
    : (LITERAL_WYSWIETL_KOMUNIKAT) NO (parametr_akcji) NZ
    ;

akcja_sprawdz_regule
    :(LITERAL_SPRAWDZ_REGULE) NO (parametr_akcji_sprawdz_regule_wywolanie_innej_reguly) NZ
    ;


parametr_akcji
    : ('"')?(tekst_wielowyrazowy|NUMERIC_VALUE|INT)('"')?
    ;

parametr_akcji_sprawdz_regule_wywolanie_innej_reguly
    : nazwa NO parametry_podawane_do_innej_reguly NZ
    ;

parametry_podawane_do_innej_reguly
    : nazwa ((',')nazwa)*
    ;

tekst_wielowyrazowy
    : IDENTIFIER (IDENTIFIER)*
    ;

LITERAL_JESLI
    : J E S L I
    ;
LITERAL_WTEDY
    :   W T E D Y
    ;

LITERAL_ORAZ
    : O R A Z
    ;
LITERAL_LUB
    : L U B
    ;
LITERAL_WYSWIETL_KOMUNIKAT
    : W Y S W I E T L
    ;

LITERAL_W_PRZECIWNYM_WYPADKU
    : W('_')P R Z E C I W N Y M('_')W Y P A D K U
    ;
LITERAL_SPRAWDZ_REGULE
    : S P R A W D Z ('_') R E G U L E
    ;

OPERATOR_POROWNANIA
    : '=='
    | '>'
    | '<'
    | '>='
    | '<='
    ;
operator_logiczny
    :  (LITERAL_ORAZ|LITERAL_LUB)
    ;
NO
    : '('
    ;
NZ
    : ')'
    ;



INT           : '0' | [1-9][0-9]* ;
NUMERIC_VALUE : '-'?[0-9]+('.'[0-9]+)? ;
IDENTIFIER    : [a-zA-Z_][a-zA-Z_0-9]* ;
RULECOMMENT   : '#' ~[\r\n]*;
NEWLINE       : '\r'? '\n'->skip;

WS : [ \r\t\u000C\n]+ -> skip ;

fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');

