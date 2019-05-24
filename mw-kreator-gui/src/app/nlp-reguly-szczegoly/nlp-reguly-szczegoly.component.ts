import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegulyService } from '../reguly.service'
import { Regula } from '../model';
@Component({
  selector: 'app-nlp-reguly-szczegoly',
  templateUrl: './nlp-reguly-szczegoly.component.html',
  styleUrls: ['./nlp-reguly-szczegoly.component.css']
})
export class NlpRegulySzczegolyComponent implements OnInit {

  constructor(private route: ActivatedRoute, private regulyUsluga: RegulyService) { }
 //private sub: any;
 // public kod: string
  public regula: Regula;

  ngOnInit() {
    /*this.route.queryParams.subscribe(params => {
      this.kod = params['kod']
    });
    this.getRegula();*/
    console.log("UTWORZONO")
    this.getRegula();
  }
  /**getKod(): string {    
    console.log("getKod")    
    return this.kod;
  }*/

  getRegula():Regula{
    var pKod:string;
    this.route.queryParams.subscribe(params => {
     pKod = params['kod']
     console.log(pKod);
    });
    this.regulyUsluga.podajRegulePoKodzie(pKod).subscribe(aRegula =>{ this.regula = aRegula});
    console.log("WYWOLANO")
    return this.regula;

    /*
    const id = +this.route.snapshot.paramMap.get('id');
    this.heroService.getHero(id)
      .subscribe(hero => this.hero = hero);
    */
  }
}


/**
 * 
 { id: 1,
    wersja: 2,
    kod: "RS-001",
    tresc: "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat \"Podana data jest równa 01-01-2000\" ." ,
    parametry:[],
    wywolaniaRegul:[],
    "sekwencja": {
      "postacKanoniczna": "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat KOMUNIKAT1 .",
      "zdaniePierwotne": "Jeśli data1 jest równa '01-01-2000' wtedy wyświetlaj komunikat KOMUNIKAT1 .",
      "tokeny": [
          "Jeśli",
          "data1",
          "jest",
          "równa",
          "'01-01-2000'",
          "wtedy",
          "wyświetlaj",
          "komunikat",
          "KOMUNIKAT1",
          "."
      ],
      "rozpoznaneTokeny": [
          {
              "kategoria": null,
              "lp": 1,
              "wartosc": "Jeśli ",
              "typ": "POCZATEK_REGULY",
              "prob": 0.19358072642932103
          },
          {
              "kategoria": null,
              "lp": 2,
              "wartosc": "data1 ",
              "typ": "LEWOSTRONNY_OPERAND_WARUNKU",
              "prob": 0.1845057576128071
          },
          {
              "kategoria": "==",
              "lp": 3,
              "wartosc": "jest równa ",
              "typ": "OPETATOR_POROWNANIA",
              "prob": 0.19175765455936755
          },
          {
              "kategoria": null,
              "lp": 4,
              "wartosc": "'01-01-2000' ",
              "typ": "PRAWOSTRONNY_OPERAND_WARUNKU",
              "prob": 0.15456750082896537
          },
          {
              "kategoria": null,
              "lp": 5,
              "wartosc": "wtedy ",
              "typ": "KONIEC_REGULY",
              "prob": 0.18938611298314553
          },
          {
              "kategoria": "WYSWIETL_KOMUNIKAT",
              "lp": 6,
              "wartosc": "wyświetlaj komunikat ",
              "typ": "AKCJA",
              "prob": 0.18995680026582853
          },
          {
              "kategoria": null,
              "lp": 7,
              "wartosc": "KOMUNIKAT1 ",
              "typ": "PARAMETR_AKCJI",
              "prob": 0.17290652945075932
          }
      ]
  }
  };
 * 
 */