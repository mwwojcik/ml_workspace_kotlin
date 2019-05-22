import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MenuComponent } from './menu/menu.component';
import { NaglowekComponent } from './naglowek/naglowek.component';
import { StopkaComponent } from './stopka/stopka.component';
import { UkladGlownyAppComponent } from './uklad-glowny-app/uklad-glowny-app.component';
import { UkladGlownyTrescComponent } from './uklad-glowny-tresc/uklad-glowny-tresc.component';

@NgModule({
  declarations: [MenuComponent,
    NaglowekComponent,
    StopkaComponent,
    UkladGlownyAppComponent,
    UkladGlownyTrescComponent],
  imports: [
    CommonModule,
    RouterModule.forChild([])
  ]
  , exports: [
    UkladGlownyTrescComponent,
    UkladGlownyAppComponent
  ]
})
export class LayoutModule { }



/*
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from './main-layout/main-layout.component';
import { FooterOnlyLayoutComponent } from './footer-only-layout/footer-only-layout.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { RouterModule } from '@angular/router';
import {FlexLayoutModule} from '@angular/flex-layout';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([]),
    FlexLayoutModule
  ],
  exports: [
    MainLayoutComponent,
    FooterOnlyLayoutComponent
  ],
  declarations: [
    MainLayoutComponent,
    FooterOnlyLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ]
})
export class LayoutModule { }
*/