import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ZawartoscStatycznaComponent } from './zawartosc-statyczna/zawartosc-statyczna.component';
import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul/aplikacja-kreator-regul.component';
import { AppRoutingModule } from './app-routing.module';
import { OprojekcieComponent } from './oprojekcie/oprojekcie.component';
import { BibliotekiComponent } from './biblioteki/biblioteki.component';
import { MenuGlowneComponent } from './menu-glowne/menu-glowne.component';
import { AppListaRegulComponent } from './app-lista-regul/app-lista-regul.component';
import { AppRegulaComponent } from './app-regula/app-regula.component';

@NgModule({
  declarations: [
    AppComponent,
    ZawartoscStatycznaComponent,
    AplikacjaKreatorRegulComponent,
    OprojekcieComponent,
    BibliotekiComponent,
    MenuGlowneComponent,
    AppListaRegulComponent,
    AppRegulaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
