import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {UkladGlownyTrescComponent} from '../layout/uklad-glowny-tresc/uklad-glowny-tresc.component'
import { OprojekcieComponent } from './oprojekcie.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'oprojekcie',
    component: UkladGlownyTrescComponent,
    children: [
      { path: '', component: OprojekcieComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OprojekcieRoutingModule { }
