import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { UkladGlownyTrescComponent } from '../layout/uklad-glowny-tresc/uklad-glowny-tresc.component';
import { OprojekcieComponent } from './oprojekcie.component';
import { RouterModule } from '@angular/router';
var routes = [
    {
        path: 'oprojekcie',
        component: UkladGlownyTrescComponent,
        children: [
            { path: '', component: OprojekcieComponent },
        ]
    }
];
var OprojekcieRoutingModule = /** @class */ (function () {
    function OprojekcieRoutingModule() {
    }
    OprojekcieRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], OprojekcieRoutingModule);
    return OprojekcieRoutingModule;
}());
export { OprojekcieRoutingModule };
//# sourceMappingURL=oprojekcie-routing.module.js.map