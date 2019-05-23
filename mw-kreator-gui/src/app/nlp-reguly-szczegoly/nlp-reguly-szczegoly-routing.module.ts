import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyAppComponent} from '../layout/uklad-glowny-app/uklad-glowny-app.component'
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'nlp-reguly-szczegoly',
    component: UkladGlownyAppComponent,
    children: [
      { path: '', component: NlpRegulySzczegolyComponent },
      { path: ':kod', component: NlpRegulySzczegolyComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulySzczegolyRoutingModule { }
