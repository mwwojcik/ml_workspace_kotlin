import { extend } from 'webdriver-js-extender';

export class WynikOperacji{}

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
    kontekstWalidacji:KontekstWalidacji;
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
    typSlownie:string;
    prob: number;
    kategoria: string;
}

class WywolanieReguly extends ObiektBazowy {
    kodRegulyWolajacej: string;
    kodRegulyWolanej: string;
    nazwyParametrowRegulyWolanej:Array<string>;
    parametry: Array<ParametrWywolaniaReguly>;
}

export class RegulaWejscie {
  constructor(public id:number, public kod:string, public tresc:string){}
  }

export class NowyParametrOW{
  regula:Regula;
  nazwaParametru:String;
}

export class KontekstWalidacji{
  komunikaty:KomunikatWalidacji[];

   czySaKomunikaty():Boolean{
    return this.komunikaty.length!=0
  }
}

export class KomunikatWalidacji{
  wartosc:String;
}
