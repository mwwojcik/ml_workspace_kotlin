import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulyListaInfoRoutingModule} from './nlp-reguly-lista-info-routing.module';
import { NlpRegulyListaInfoComponent } from './nlp-reguly-lista-info.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulyListaInfoRoutingModule
  ],
  /*declarations: [NlpRegulyListaComponent]*/
})
export class NlpRegulyListaInfoModule {}
