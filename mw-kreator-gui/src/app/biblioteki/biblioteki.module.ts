import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {BibliotekiRoutingModule } from './biblioteki-routing.module';
import { BibliotekiComponent } from './biblioteki.component';

@NgModule({
  imports: [
    CommonModule,
    BibliotekiRoutingModule
  ],
  declarations: [BibliotekiComponent]
})
export class BibliotekiModule {}
