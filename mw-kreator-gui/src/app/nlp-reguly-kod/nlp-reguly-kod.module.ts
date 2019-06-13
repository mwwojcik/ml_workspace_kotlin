import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulyKodRoutingModule } from './nlp-reguly-kod-routing.module';
import { NlpRegulyKodComponent } from './nlp-reguly-kod.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulyKodRoutingModule
  ]//,
  /*declarations: [NlpRegulySzczegolyComponent]*/
})
export class NlpRegulyKodModule {}
