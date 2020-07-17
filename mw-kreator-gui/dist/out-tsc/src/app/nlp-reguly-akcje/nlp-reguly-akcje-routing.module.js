import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { UkladGlownyAppComponent } from '../layout/uklad-glowny-app/uklad-glowny-app.component';
import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje.component';
import { RouterModule } from '@angular/router';
var routes = [
    {
        path: 'nlp-reguly-akcje',
        component: UkladGlownyAppComponent,
        children: [
            { path: '', component: NlpRegulyAkcjeComponent }
        ]
    }
];
var NlpRegulyAkcjeRoutingModule = /** @class */ (function () {
    function NlpRegulyAkcjeRoutingModule() {
    }
    NlpRegulyAkcjeRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], NlpRegulyAkcjeRoutingModule);
    return NlpRegulyAkcjeRoutingModule;
}());
export { NlpRegulyAkcjeRoutingModule };
//# sourceMappingURL=nlp-reguly-akcje-routing.module.js.map