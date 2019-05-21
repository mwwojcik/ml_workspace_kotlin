import { Component, OnInit } from '@angular/core';
import { RegulaBiznesowa } from '../model';

@Component({
  selector: 'app-app-lista-regul',
  templateUrl: './app-lista-regul.component.html',
  styleUrls: ['./app-lista-regul.component.css']
})
export class AppListaRegulComponent implements OnInit {

  regula: RegulaBiznesowa = {
  kod: 'RS-001'
};

constructor() { }

ngOnInit() {
}

}
