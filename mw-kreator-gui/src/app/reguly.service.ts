import { Injectable, OnInit } from '@angular/core';
import { REGULY } from './reguly.mock'
import { Regula } from './model'
import SampleJson from './reguly.json';

@Injectable({
  providedIn: 'root'
})
export class RegulyService {

  private reguly: Array<Regula>;

  constructor() {
    this.reguly=SampleJson
   }

 

  podajReguly() {
    return this.reguly;
  }

  podajRegulePoKodzie(aKod:string){
    //var result = new Map(SampleJson.map(i => [i.kod, i]));
    return  this.reguly[1];//result.get(aKod);
  }
}
