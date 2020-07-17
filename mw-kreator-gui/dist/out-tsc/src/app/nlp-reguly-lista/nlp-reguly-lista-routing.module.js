import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { UkladGlownyAppComponent } from '../layout/uklad-glowny-app/uklad-glowny-app.component';
import { NlpRegulyListaComponent } from './nlp-reguly-lista.component';
import { RouterModule } from '@angular/router';
var routes = [
    {
        path: 'nlp-reguly-lista',
        component: UkladGlownyAppComponent,
        children: [
            { path: '', component: NlpRegulyListaComponent }
        ]
    }
];
var NlpRegulyListaRoutingModule = /** @class */ (function () {
    function NlpRegulyListaRoutingModule() {
    }
    NlpRegulyListaRoutingModule.prototype.ngOnInit = function () { };
    NlpRegulyListaRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], NlpRegulyListaRoutingModule);
    return NlpRegulyListaRoutingModule;
}());
export { NlpRegulyListaRoutingModule };
//# sourceMappingURL=nlp-reguly-lista-routing.module.js.map