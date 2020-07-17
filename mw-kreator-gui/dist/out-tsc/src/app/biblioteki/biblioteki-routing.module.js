import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { UkladGlownyTrescComponent } from '../layout/uklad-glowny-tresc/uklad-glowny-tresc.component';
import { BibliotekiComponent } from './biblioteki.component';
import { RouterModule } from '@angular/router';
var routes = [
    {
        path: 'biblioteki',
        component: UkladGlownyTrescComponent,
        children: [
            { path: '', component: BibliotekiComponent }
        ]
    }
];
var BibliotekiRoutingModule = /** @class */ (function () {
    function BibliotekiRoutingModule() {
    }
    BibliotekiRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], BibliotekiRoutingModule);
    return BibliotekiRoutingModule;
}());
export { BibliotekiRoutingModule };
//# sourceMappingURL=biblioteki-routing.module.js.map