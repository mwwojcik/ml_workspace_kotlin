import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ZawartoscStatycznaComponent }      from './zawartosc-statyczna/zawartosc-statyczna.component';
import { AplikacjaKreatorRegulComponent }  from './aplikacja-kreator-regul/aplikacja-kreator-regul.component';

const routes: Routes = [
  { path: 'info', component: ZawartoscStatycznaComponent },
  { path: 'reguly', component: AplikacjaKreatorRegulComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {



}