import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';

import { OprojekcieModule } from './oprojekcie/oprojekcie.module';
import { BibliotekiModule } from './biblioteki/biblioteki.module';
import  {LayoutModule} from './layout/layout.module'
import {NlpRegulyAkcjeModule} from './nlp-reguly-akcje/nlp-reguly-akcje.module'
import {NlpRegulyListaModule} from './nlp-reguly-lista/nlp-reguly-lista.module'
import {NlpRegulySzczegolyModule} from './nlp-reguly-szczegoly/nlp-reguly-szczegoly.module'

import {UkladGlownyTrescComponent} from './layout/uklad-glowny-tresc/uklad-glowny-tresc.component'
import {UkladGlownyAppComponent} from './layout/uklad-glowny-app/uklad-glowny-app.component'

import {MenuComponent} from './layout/menu/menu.component'
import {StopkaComponent} from './layout/stopka/stopka.component'
import {NlpRegulyListaComponent} from './nlp-reguly-lista/nlp-reguly-lista.component'
import {NlpRegulySzczegolyComponent} from './nlp-reguly-szczegoly/nlp-reguly-szczegoly.component'

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
    UkladGlownyAppComponent,
    MenuComponent,
    StopkaComponent,
    NlpRegulyListaComponent,
    NlpRegulySzczegolyComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    OprojekcieModule,
    BibliotekiModule,
    NlpRegulyAkcjeModule,
    NlpRegulyListaModule,
    NlpRegulySzczegolyModule
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