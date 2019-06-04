import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegulyService } from '../reguly.service'
import { Regula,NowyParametrOW } from '../model';
import {NgForm } from '@angular/forms';
import * as $ from 'jquery';
import {ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-nlp-reguly-szczegoly',
  templateUrl: './nlp-reguly-szczegoly.component.html',
  styleUrls: ['./nlp-reguly-szczegoly.component.css']
})
export class NlpRegulySzczegolyComponent implements OnInit {

  @ViewChild('closeBtn') closeBtn: ElementRef;

  nazwaNowegoParametru:string;

  constructor(private route: ActivatedRoute, private regulyUsluga: RegulyService) { }

  dopuszczalneTypyParametrow=['Liczba','Napis','Kwota','Data'];

  powers = ['Really Smart', 'Super Flexible',
            'Super Hot', 'Weather Changer'];

  model = new Hero(18, 'Dr IQ', this.powers[0], 'Chuck Overstreet');

  public regula: Regula;

  ngOnInit() {
    this.getRegula();
  }

  getRegula(): Regula {

    this.route.queryParams.subscribe(params => {
      let pKod: string; pKod = params.kod;
      this.regulyUsluga.podajRegulePoKodzie(pKod).subscribe(aRegula => {
        this.regula = aRegula;
      });
    });
    return this.regula;
  }

dodajParametrDoReguly(){
  let nowyParam:NowyParametrOW=new NowyParametrOW();
  nowyParam.nazwaParametru=this.nazwaNowegoParametru;
  nowyParam.regula=this.regula;
  this.regulyUsluga.dodajParametrDoReguly(nowyParam).subscribe(
    params=>{
      console.log("udalo sie")
      this.closeModal();
    }
  )
}

private closeModal(): void {
      this.closeBtn.nativeElement.click();
  }

}

export class Hero {

  constructor(
    public id: number,
    public name: string,
    public power: string,
    public alterEgo?: string
  ) {  }

}
