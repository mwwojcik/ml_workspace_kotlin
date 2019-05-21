import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import { AppRoutingModule } from './app-routing.module';
import { OprojekcieComponent } from './oprojekcie/oprojekcie.component';
import { BibliotekiComponent } from './biblioteki/biblioteki.component';
import { NlpRegulyListaComponent } from './nlp-reguly-lista/nlp-reguly-lista.component';
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly/nlp-reguly-szczegoly.component';
import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje/nlp-reguly-akcje.component';


@NgModule({
  declarations: [
    AppComponent,
    OprojekcieComponent,
    BibliotekiComponent,
    NlpRegulyListaComponent,
    NlpRegulySzczegolyComponent,
    NlpRegulyAkcjeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
