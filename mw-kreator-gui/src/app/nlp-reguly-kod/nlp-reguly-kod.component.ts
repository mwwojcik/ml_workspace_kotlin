import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula } from '../model'

@Component({
  selector: 'app-nlp-reguly-kod',
  templateUrl: './nlp-reguly-kod.component.html',
  styleUrls: ['./nlp-reguly-kod.component.css']
})
export class NlpRegulyKodComponent implements OnInit {

  reguly: Regula[];
  wszystkiePoprawne=false;
  kod=""

  getReguly() {
    return this.reguly;
  }

  constructor(private regulyUsluga: RegulyService) { }

  ngOnInit() {
    this.regulyUsluga.podajReguly()
    .subscribe(aReguly => {
      this.reguly = aReguly

      this.wszystkiePoprawne=true

      for(let r of aReguly){
         if(r.kontekstWalidacji.komunikaty.length!=0){
           this.wszystkiePoprawne=false;
           break;
         }
      }

      if(this.wszystkiePoprawne==true){
        this.regulyUsluga.generujKod().subscribe(aKodWrapper=>{
          let str=atob(aKodWrapper.tekst as string)
          this.kod=str

        })
      }

    });
  }
}
