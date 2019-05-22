import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulyListaRoutingModule } from './nlp-reguly-lista-routing.module';
import { NlpRegulyListaComponent } from './nlp-reguly-lista.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulyListaRoutingModule
  ],
  /*declarations: [NlpRegulyListaComponent]*/
})
export class NlpRegulyListaModule {}