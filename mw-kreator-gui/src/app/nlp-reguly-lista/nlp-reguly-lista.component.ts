import { Component, OnInit } from '@angular/core';
import {REGULY} from '../reguly.mock'
import {Regula} from '../model'
import SampleJson from '../reguly.json';

@Component({
  selector: 'app-nlp-reguly-lista',
  templateUrl: './nlp-reguly-lista.component.html',
  styleUrls: ['./nlp-reguly-lista.component.css']
})
export class NlpRegulyListaComponent implements OnInit {

  reguly : Regula[];

  getReguly(){
    return this.reguly
  }

  constructor() { }

  ngOnInit() {
    this.reguly=REGULY
    this.reguly=SampleJson
  }

}
