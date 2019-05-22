import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulySzczegolyRoutingModule } from './nlp-reguly-szczegoly-routing.module';
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulySzczegolyRoutingModule
  ]//,
  /*declarations: [NlpRegulySzczegolyComponent]*/
})
export class NlpRegulySzczegolyModule {}