import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulyWejscieRoutingModule } from './nlp-reguly-wejscie-routing.module';
import { NlpRegulyWejscieComponent } from './nlp-reguly-wejscie.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulyWejscieRoutingModule
  ]//,
  /*declarations: [NlpRegulySzczegolyComponent]*/
})
export class NlpRegulyWejscieModule {}
