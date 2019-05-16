import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ZawartoscStatycznaComponent } from './zawartosc-statyczna/zawartosc-statyczna.component';
import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul/aplikacja-kreator-regul.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ZawartoscStatycznaComponent,
    AplikacjaKreatorRegulComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
