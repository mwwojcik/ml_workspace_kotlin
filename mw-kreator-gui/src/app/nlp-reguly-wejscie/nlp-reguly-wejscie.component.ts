import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula } from '../model'
import {FormGroup,FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-nlp-reguly-wejscie',
  templateUrl: './nlp-reguly-wejscie.component.html',
  styleUrls: ['./nlp-reguly-wejscie.component.css']
})
export class NlpRegulyWejscieComponent implements OnInit {

  addForm: FormGroup;
  reguly: Regula[];

  getReguly() {
    return this.reguly;
  }

  constructor(private regulyUsluga: RegulyService,private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
     kod: [''],
     tresc: ['']
   });

    this.regulyUsluga.podajReguly()
    .subscribe(aReguly => this.reguly = aReguly);
  }

  usunRegule(aKod:string){
    console.log('aKod=>USUNIECIE!=>'+aKod);
  }

  dodajRegule(){
    console.log("dodaj regule")
  }

}
