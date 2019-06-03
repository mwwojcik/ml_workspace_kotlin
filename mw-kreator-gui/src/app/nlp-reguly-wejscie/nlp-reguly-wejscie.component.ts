import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula,RegulaWejscie } from '../model'
import {NgForm } from '@angular/forms';
import * as $ from 'jquery';
import { Router } from '@angular/router';



import {ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-nlp-reguly-wejscie',
  templateUrl: './nlp-reguly-wejscie.component.html',
  styleUrls: ['./nlp-reguly-wejscie.component.css']
})
export class NlpRegulyWejscieComponent implements OnInit {
  @ViewChild('closeBtn') closeBtn: ElementRef;

  komunikat:string=""

  model:RegulaWejscie={
    id:-1,
    kod:"[wartość zostanie wygenerowana]",
    tresc:"tresc"
  }


  reguly: RegulaWejscie[];

  getReguly() {
    return this.reguly;
  }

  constructor(private regulyUsluga: RegulyService,private router:Router) { }

  ngOnInit() {
    this.regulyUsluga.podajReguly()
    .subscribe(regulyPelne =>{
      this.reguly = this.regulyUsluga.podajRegulyWejscie(regulyPelne);
      this.regulyUsluga.aktualizujObiekty(regulyPelne);
    });

    /*$(document).ready(function(){
        $("submit").click(function(){
            $('#modal').modal('hide');
            console.log('Probuje ukryc okno')
        });
});*/

  }

  usunRegule(aId:number){
    this.wyczyscKomunikat();
    this.regulyUsluga.usunRegule(aId)
    .subscribe(regulyPelne => {
        this.komunikat="Reguła została usunięta."
        this.reguly=this.regulyUsluga.podajRegulyWejscie(regulyPelne);
        this.regulyUsluga.aktualizujObiekty(regulyPelne);
    });

  }

  edytujRegule(aRegulaWejscie:RegulaWejscie){
    this.model=aRegulaWejscie;
  }

  zapiszRegule(){

    this.wyczyscKomunikat();
    if(this.model.id<0){
    this.regulyUsluga.dodajRegule(this.model).subscribe(regulyPelne => {
      this.komunikat="Reguła została dodana."
      this.reguly=this.regulyUsluga.podajRegulyWejscie(regulyPelne);
      this.regulyUsluga.aktualizujObiekty(regulyPelne);

      let r=this.reguly.find(reg=>reg.tresc==this.model.tresc)
      this.model.kod=r.kod;
      this.model.id=r.id;
      this.router.navigate(['/nlp-reguly-szczegoly'],{queryParams:{kod:r.kod}});
      //.router.navigate(['/products'], { queryParams: { order: 'popular' } });
    });
  }else{
    this.regulyUsluga.modyfikujRegule(this.model)
    .subscribe(regulyPelne => {
      this.reguly = this.regulyUsluga.podajRegulyWejscie(regulyPelne);
      this.komunikat="Reguła została zmodyfikowana."
      this.regulyUsluga.aktualizujObiekty(regulyPelne);
    });
  }
    this.closeModal();
  }

 wyczyscKomunikat(){
   this.komunikat=""
 }

 przejdzDoPodgladu(aRegulaWejscie:RegulaWejscie){
   this.router.navigate(['/nlp-reguly-szczegoly'],{queryParams:{kod:aRegulaWejscie.kod}});
 }

 private closeModal(): void {
       this.closeBtn.nativeElement.click();
   }
}
/*
gotoHeroes() {
  this.router.navigate(['/heroes']);
}
*/
