import { extend } from 'webdriver-js-extender';


export class ObiektBazowy {
    id: number;
    wersja: number;
}

export class RegulaBiznesowa {
    kod: string;
}

export class Parametr extends ObiektBazowy {
    nazwa: string;
    typ: string;
    wartoscDomyslna: string;
    czyUsuwalny: number = 0;
}

export class ParametrWywolaniaReguly extends ObiektBazowy {
    nazwaParametruRegulyWolajacej: string;
    nazwaParametruRegulyWolanej: string;
}

export class Regula extends ObiektBazowy {
    kod: string
    tresc: string
    sekwencja: Sekwencja;
    parametry: Array<Parametr>;
    wywolaniaRegul: Array<WywolanieReguly>;
}

class Sekwencja {
    zdaniePierwotne: string;
    postacKanoniczna: string;
    tokeny: Array<string>;
    rozpoznaneTokeny: Array<RozpoznanyToken>;
    komunikaty: Map<string,string>;
}

class RozpoznanyToken {
    lp: number;
    wartosc: string;
    typ: string;
    prob: number;
    kategoria: string;
}

class WywolanieReguly extends ObiektBazowy {
    kodRegulyWolajacej: string;
    kodRegulyWolanej: string;
    parametry: Array<ParametrWywolaniaReguly>;
}