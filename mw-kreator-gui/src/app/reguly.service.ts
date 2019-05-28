import { Injectable, OnInit } from '@angular/core';

import { Regula,RegulaWejscie } from './model'
import SampleJson from './reguly.json';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegulyService {

  private reguly: Array<Regula>;

  constructor() {
    this.reguly=SampleJson
   }



  podajReguly():Observable<Regula[]> {
    return of(this.reguly);
  }

  podajRegulePoKodzie(aKod:string):Observable<Regula>{
    //var result = new Map(SampleJson.map(i => [i.kod, i]));

    //of(HEROES.find(hero => hero.id === id));
    return  of(this.reguly.find(reg=>reg.kod==aKod));//result.get(aKod);

  }

  podajRegulyWejscie():Observable<RegulaWejscie[]>{
    return of(this.reguly.map(item=>new RegulaWejscie(item.kod,item.tresc)
  ));
  }
}
