import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ZawartoscStatycznaComponent } from './zawartosc-statyczna/zawartosc-statyczna.component';
import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul/aplikacja-kreator-regul.component';
import { OprojekcieComponent } from './oprojekcie/oprojekcie.component';
import { BibliotekiComponent } from './biblioteki/biblioteki.component';
import { AppListaRegulComponent } from './app-lista-regul/app-lista-regul.component';
import { AppRegulaComponent } from './app-regula/app-regula.component';

const routes: Routes = [
  { path: 'oprojekcie', component: OprojekcieComponent },
  { path: 'biblioteki', component: BibliotekiComponent },
  { path: 'reguly', component: AplikacjaKreatorRegulComponent },
  { path: 'reguly/regula/:kod', component: AppRegulaComponent },
  { path: '', redirectTo: '/oprojekcie', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {



}