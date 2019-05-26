import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula } from '../model'

@Component({
  selector: 'app-nlp-reguly-wejscie',
  templateUrl: './nlp-reguly-wejscie.component.html',
  styleUrls: ['./nlp-reguly-wejscie.component.css']
})
export class NlpRegulyWejscieComponent implements OnInit {

  reguly: Regula[];

  getReguly() {
    return this.reguly;
  }

  constructor(private regulyUsluga: RegulyService) { }

  ngOnInit() {
    this.regulyUsluga.podajReguly()
    .subscribe(aReguly => this.reguly = aReguly);
  }
}
