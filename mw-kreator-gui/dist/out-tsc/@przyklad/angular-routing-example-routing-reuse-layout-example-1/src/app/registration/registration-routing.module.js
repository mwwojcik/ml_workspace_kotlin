import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FooterOnlyLayoutComponent } from '../layout/footer-only-layout/footer-only-layout.component';
import { RegistrationComponent } from './registration.component';
var routes = [
    {
        path: 'registration',
        component: FooterOnlyLayoutComponent,
        children: [
            { path: '', component: RegistrationComponent }
        ]
    }
];
var RegistrationRoutingModule = /** @class */ (function () {
    function RegistrationRoutingModule() {
    }
    RegistrationRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], RegistrationRoutingModule);
    return RegistrationRoutingModule;
}());
export { RegistrationRoutingModule };
//# sourceMappingURL=registration-routing.module.js.map