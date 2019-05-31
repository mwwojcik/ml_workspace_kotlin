import { Injectable, OnInit } from '@angular/core';

import { Regula,RegulaWejscie } from './model'
import SampleJson from './reguly.json';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegulyService {
  private url="http://localhost:8080"

  private reguly: Array<Regula>;

  constructor(private http: HttpClient) {
    //this.reguly=SampleJson
   }



  podajReguly():Observable<Regula[]> {
    //return of(this.reguly);
      this.http.get(this.url+'/reguly').subscribe(reguly=>{
        console.log("SUKCES")
        this.reguly=reguly as Regula[];
      })
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

/*
constructor(private http: HttpClient) {

  }
  getEmployee() {
    return this.http.get(this.url+'/employees')
  }
*/
