import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyAppWejscieComponent} from '../layout/uklad-glowny-app-wejscie/uklad-glowny-app-wejscie.component'
import { NlpRegulyWejscieComponent } from './nlp-reguly-wejscie.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'nlp-reguly-wejscie',
    component: UkladGlownyAppWejscieComponent,
    children: [
      { path: '', component: NlpRegulyWejscieComponent },
      { path: ':kod', component: NlpRegulyWejscieComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulyWejscieRoutingModule { }
