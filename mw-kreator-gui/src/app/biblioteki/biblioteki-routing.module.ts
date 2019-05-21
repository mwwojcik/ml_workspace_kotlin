import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';


import {UkladGlownyTrescComponent} from '../layout/uklad-glowny-tresc/uklad-glowny-tresc.component'
import { BibliotekiComponent } from './biblioteki.component';
import { Routes, RouterModule } from '@angular/router';
const routes: Routes = [
  {
    path: 'biblioteki',
    component: UkladGlownyTrescComponent,
    children: [
      { path: '', component: BibliotekiComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BibliotekiRoutingModule { }
