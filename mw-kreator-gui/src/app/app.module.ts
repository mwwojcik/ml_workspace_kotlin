import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';

import { OprojekcieModule } from './oprojekcie/oprojekcie.module';
import { BibliotekiModule } from './biblioteki/biblioteki.module';
import  {LayoutModule} from './layout/layout.module'

import {UkladGlownyTrescComponent} from './layout/uklad-glowny-tresc/uklad-glowny-tresc.component'
import {MenuComponent} from './layout/menu/menu.component'
import {StopkaComponent} from './layout/stopka/stopka.component'
const routes: Routes = [
  {
    path: '',
    redirectTo: '/oprojekcie',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    UkladGlownyTrescComponent,
    MenuComponent,
    StopkaComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    OprojekcieModule,
    BibliotekiModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

/*
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    LayoutModule,
    LoginModule,
    DashboardModule,
    RegistrationModule,
    UsersModule,
    AccountSettingsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

*/ 