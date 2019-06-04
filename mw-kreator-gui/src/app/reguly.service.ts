import { Injectable, OnInit } from '@angular/core';

import { Regula,RegulaWejscie,WynikOperacji,NowyParametrOW } from './model'
import SampleJson from './reguly.json';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegulyService {
  private url="http://localhost:8080"

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  reguly:Regula[];

  constructor(private http: HttpClient) {
    //this.reguly=SampleJson
    this.podajReguly();
   }

  podajRegulyWejscie(aRegulyPelne:Regula[]):RegulaWejscie[]{
    return aRegulyPelne.map(r=>new RegulaWejscie(r.id,r.kod,r.tresc))
  }

  podajReguly():Observable<Regula[]> {
    //return of(this.reguly);
      return this.http.get<Regula[]>(this.url+'/reguly');
  }

  podajRegulePoKodzie(aKod:string):Observable<Regula>{
    //var result = new Map(SampleJson.map(i => [i.kod, i]));

    //of(HEROES.find(hero => hero.id === id));
    return  of(this.reguly.find(reg=>reg.kod==aKod));//result.get(aKod);

  }

  dodajRegule(aRegulaWejscie:RegulaWejscie):Observable<Regula[]>{
    return this.http.post<Regula[]>(this.url+"/regula",aRegulaWejscie)
  }

  usunRegule(aId:number):Observable<Regula[]>{
    return this.http.delete<Regula[]>(this.url+"/regula"+"/"+aId,this.httpOptions)
  }

  modyfikujRegule(aRegulaWejscie:RegulaWejscie):Observable<Regula[]>{
    return this.http.put<Regula[]>(this.url+"/regula",aRegulaWejscie,this.httpOptions)
  }


  dodajParametrDoReguly(aNowyParametr:NowyParametrOW):Observable<Regula[]>{
    return this.http.put<Regula[]>(this.url+"/parametr",aNowyParametr,this.httpOptions)
  }


  aktualizujObiekty(aReguly:Regula[]){
    this.reguly=aReguly;
  }

}
