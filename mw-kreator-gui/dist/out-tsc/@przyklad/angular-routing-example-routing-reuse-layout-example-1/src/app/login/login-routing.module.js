import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FooterOnlyLayoutComponent } from '../layout/footer-only-layout/footer-only-layout.component';
import { LoginComponent } from './login.component';
var routes = [
    {
        path: 'login',
        component: FooterOnlyLayoutComponent,
        children: [
            { path: '', component: LoginComponent },
        ]
    }
];
var LoginRoutingModule = /** @class */ (function () {
    function LoginRoutingModule() {
    }
    LoginRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], LoginRoutingModule);
    return LoginRoutingModule;
}());
export { LoginRoutingModule };
//# sourceMappingURL=login-routing.module.js.map