import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { UkladGlownyAppComponent } from '../layout/uklad-glowny-app/uklad-glowny-app.component';
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly.component';
import { RouterModule } from '@angular/router';
var routes = [
    {
        path: 'nlp-reguly-szczegoly',
        component: UkladGlownyAppComponent,
        children: [
            { path: '', component: NlpRegulySzczegolyComponent },
            { path: ':kod', component: NlpRegulySzczegolyComponent }
        ]
    }
];
var NlpRegulySzczegolyRoutingModule = /** @class */ (function () {
    function NlpRegulySzczegolyRoutingModule() {
    }
    NlpRegulySzczegolyRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], NlpRegulySzczegolyRoutingModule);
    return NlpRegulySzczegolyRoutingModule;
}());
export { NlpRegulySzczegolyRoutingModule };
//# sourceMappingURL=nlp-reguly-szczegoly-routing.module.js.map