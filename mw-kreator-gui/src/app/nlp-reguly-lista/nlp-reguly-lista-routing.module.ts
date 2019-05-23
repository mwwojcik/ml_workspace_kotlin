import { NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyAppComponent} from '../layout/uklad-glowny-app/uklad-glowny-app.component'
import { NlpRegulyListaComponent } from './nlp-reguly-lista.component';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: 'nlp-reguly-lista',
    component: UkladGlownyAppComponent,
    children: [
      { path: '', component: NlpRegulyListaComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulyListaRoutingModule implements OnInit{
  
  constructor() {
   
   }

   ngOnInit(){}

 }
