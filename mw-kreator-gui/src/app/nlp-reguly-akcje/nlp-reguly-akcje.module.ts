import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {NlpRegulyAkcjeRoutingModule } from './nlp-reguly-akcje-routing.module';
import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje.component';

@NgModule({
  imports: [
    CommonModule,
    NlpRegulyAkcjeRoutingModule
  ],
  declarations: [NlpRegulyAkcjeComponent]
})
export class NlpRegulyAkcjeModule {}