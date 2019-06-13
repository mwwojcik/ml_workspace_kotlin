import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {UkladGlownyAppWejscieComponent} from '../layout/uklad-glowny-app-wejscie/uklad-glowny-app-wejscie.component'
import {UkladGlownyAppComponent} from '../layout/uklad-glowny-app/uklad-glowny-app.component'
import { NlpRegulyKodComponent } from './nlp-reguly-kod.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'nlp-reguly-kod',
    component: UkladGlownyAppWejscieComponent,
    children: [
      { path: '', component: NlpRegulyKodComponent },
      { path: ':kod', component: NlpRegulyKodComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NlpRegulyKodRoutingModule { }
