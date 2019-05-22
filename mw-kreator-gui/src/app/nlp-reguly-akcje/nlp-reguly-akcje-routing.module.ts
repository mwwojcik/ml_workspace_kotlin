import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyAppComponent} from '../layout/uklad-glowny-app/uklad-glowny-app.component'
import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'nlp-reguly-akcje',
    component: UkladGlownyAppComponent,
    children: [
      { path: '', component: NlpRegulyAkcjeComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulyAkcjeRoutingModule { }
