import { NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyAppComponent} from '../layout/uklad-glowny-app/uklad-glowny-app.component'
import { NlpRegulyListaInfoComponent } from './nlp-reguly-lista-info.component';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: 'nlp-reguly-lista-info',
    component: UkladGlownyAppComponent,
    children: [
      { path: '', component: NlpRegulyListaInfoComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulyListaInfoRoutingModule implements OnInit{

  constructor() {

   }

   ngOnInit(){}

 }
