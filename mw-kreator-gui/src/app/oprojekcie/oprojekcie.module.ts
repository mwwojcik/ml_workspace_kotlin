import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OprojekcieRoutingModule } from './oprojekcie-routing.module';
import { OprojekcieComponent } from './oprojekcie.component';

@NgModule({
  imports: [
    CommonModule,
    OprojekcieRoutingModule
  ],
  declarations: [OprojekcieComponent]
})
export class OprojekcieModule { }
