import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ZawartoscStatycznaComponent } from './zawartosc-statyczna/zawartosc-statyczna.component';
import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul/aplikacja-kreator-regul.component';
import { AppRoutingModule } from './app-routing.module';
import { OmnieComponent } from './omnie/omnie.component';
import { OprojekcieComponent } from './oprojekcie/oprojekcie.component';
import { BibliotekiComponent } from './biblioteki/biblioteki.component';
import { MenuGlowneComponent } from './menu-glowne/menu-glowne.component';

@NgModule({
  declarations: [
    AppComponent,
    ZawartoscStatycznaComponent,
    AplikacjaKreatorRegulComponent,
    OmnieComponent,
    OprojekcieComponent,
    BibliotekiComponent,
    MenuGlowneComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
