import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MenuComponent } from './menu/menu.component';
import { NaglowekComponent } from './naglowek/naglowek.component';
import { StopkaComponent } from './stopka/stopka.component';
import { UkladGlownyAppComponent } from './uklad-glowny-app/uklad-glowny-app.component';
import { UkladGlownyTrescComponent } from './uklad-glowny-tresc/uklad-glowny-tresc.component';

@NgModule({
  declarations: [MenuComponent, NaglowekComponent, StopkaComponent, UkladGlownyAppComponent, UkladGlownyTrescComponent],
  imports: [
    CommonModule
  ]
})
export class LayoutModule { }
