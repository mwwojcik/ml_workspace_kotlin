import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula,RegulaWejscie } from '../model'
import {NgForm } from '@angular/forms';

@Component({
  selector: 'app-nlp-reguly-wejscie',
  templateUrl: './nlp-reguly-wejscie.component.html',
  styleUrls: ['./nlp-reguly-wejscie.component.css']
})
export class NlpRegulyWejscieComponent implements OnInit {


  model:RegulaWejscie={
    kod:"KOD",
    tresc:"tresc"
  }

  reguly: RegulaWejscie[];

  getReguly() {
    return this.reguly;
  }

  constructor(private regulyUsluga: RegulyService) { }

  ngOnInit() {
    this.regulyUsluga.podajRegulyWejscie()
    .subscribe(aReguly => this.reguly = aReguly);
  }

  usunRegule(aId:number){
    this.regulyUsluga.usunRegule(aId)
    .subscribe(aReguly => this.reguly = aReguly);
    console.log('aKod=>USUNIECIE!=>'+aId);
  }

  edytujRegule(aRegulaWejscie:RegulaWejscie){
    this.model=aRegulaWejscie;
    this.regulyUsluga.modyfikujRegule(aRegulaWejscie)
    .subscribe(aReguly => this.reguly = aReguly);
  }

  dodajRegule(){
    this.regulyUsluga.dodajRegule(this.model)
    .subscribe(aReguly => this.reguly = aReguly);
  }

}
