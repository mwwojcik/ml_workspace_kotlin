import * as tslib_1 from "tslib";
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { OprojekcieModule } from './oprojekcie/oprojekcie.module';
import { BibliotekiModule } from './biblioteki/biblioteki.module';
import { NlpRegulyAkcjeModule } from './nlp-reguly-akcje/nlp-reguly-akcje.module';
import { NlpRegulyListaModule } from './nlp-reguly-lista/nlp-reguly-lista.module';
import { NlpRegulySzczegolyModule } from './nlp-reguly-szczegoly/nlp-reguly-szczegoly.module';
import { UkladGlownyTrescComponent } from './layout/uklad-glowny-tresc/uklad-glowny-tresc.component';
import { UkladGlownyAppComponent } from './layout/uklad-glowny-app/uklad-glowny-app.component';
import { MenuComponent } from './layout/menu/menu.component';
import { StopkaComponent } from './layout/stopka/stopka.component';
import { NlpRegulyListaComponent } from './nlp-reguly-lista/nlp-reguly-lista.component';
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly/nlp-reguly-szczegoly.component';
var routes = [
    {
        path: '',
        redirectTo: '/oprojekcie',
        pathMatch: 'full'
    }
];
var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib_1.__decorate([
        NgModule({
            declarations: [
                AppComponent,
                UkladGlownyTrescComponent,
                UkladGlownyAppComponent,
                MenuComponent,
                StopkaComponent,
                NlpRegulyListaComponent,
                NlpRegulySzczegolyComponent
            ],
            imports: [
                BrowserModule,
                RouterModule.forRoot(routes),
                OprojekcieModule,
                BibliotekiModule,
                NlpRegulyAkcjeModule,
                NlpRegulyListaModule,
                NlpRegulySzczegolyModule
            ],
            providers: [],
            bootstrap: [AppComponent]
        })
    ], AppModule);
    return AppModule;
}());
export { AppModule };
/*
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    LayoutModule,
    LoginModule,
    DashboardModule,
    RegistrationModule,
    UsersModule,
    AccountSettingsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

*/ 
//# sourceMappingURL=app.module.js.map