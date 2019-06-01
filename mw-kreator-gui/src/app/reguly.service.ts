import { Injectable, OnInit } from '@angular/core';

import { Regula,RegulaWejscie } from './model'
import SampleJson from './reguly.json';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegulyService {
  private url="http://localhost:8080"

  private reguly: Array<Regula>;

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  constructor(private http: HttpClient) {
    //this.reguly=SampleJson
    this.podajReguly();
   }




  podajReguly():Observable<Regula[]> {
    //return of(this.reguly);
      this.http.get(this.url+'/reguly').subscribe(reguly=>{
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
    this.podajReguly().subscribe()
    return of(this.reguly.map(item=>new RegulaWejscie(item.id,item.kod,item.tresc)
  ));
  }

  dodajRegule(aRegulaWejscie:RegulaWejscie):Observable<RegulaWejscie[]>{
    this.http.post(this.url+"/regula",aRegulaWejscie).subscribe(params=>
    this.reguly=params as Regula[])
    return this.podajRegulyWejscie()
  }

  usunRegule(aId:number):Observable<RegulaWejscie[]>{
    this.http.delete(this.url+"/regula"+"/"+aId,this.httpOptions)
    .subscribe(params=>
    this.reguly=params as Regula[])
    return this.podajRegulyWejscie()
  }

  modyfikujRegule(aRegulaWejscie:RegulaWejscie):Observable<RegulaWejscie[]>{
    this.http.put(this.url+"/regula",aRegulaWejscie,this.httpOptions).subscribe(params=>
    this.reguly=params as Regula[])
    return this.podajRegulyWejscie()
  }

}

/*
constructor(private http: HttpClient) {

  }
  getEmployee() {
    return this.http.get(this.url+'/employees')
  }
*/
