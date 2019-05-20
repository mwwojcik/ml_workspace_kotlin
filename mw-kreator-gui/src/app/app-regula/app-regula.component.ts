import { Component, OnInit, Input } from '@angular/core';
import { RegulaBiznesowa } from '../model';

@Component({
  selector: 'app-app-regula',
  templateUrl: './app-regula.component.html',
  styleUrls: ['./app-regula.component.css']
})
export class AppRegulaComponent implements OnInit {

  @Input() regula: RegulaBiznesowa;

  constructor() { }

  ngOnInit() {
  }

}
