import { Component, OnInit } from '@angular/core';
import { RegulyService } from '../reguly.service';
import { Regula } from '../model'

@Component({
  selector: 'app-nlp-reguly-lista',
  templateUrl: './nlp-reguly-lista.component.html',
  styleUrls: ['./nlp-reguly-lista.component.css']
})
export class NlpRegulyListaComponent implements OnInit {

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
