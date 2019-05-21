import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OprojekcieComponent } from './oprojekcie/oprojekcie.component';
import { BibliotekiComponent } from './biblioteki/biblioteki.component';


const routes: Routes = [
  { path: 'oprojekcie', component: OprojekcieComponent },
  { path: 'biblioteki', component: BibliotekiComponent },
  { path: '', redirectTo: '/oprojekcie', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {



}