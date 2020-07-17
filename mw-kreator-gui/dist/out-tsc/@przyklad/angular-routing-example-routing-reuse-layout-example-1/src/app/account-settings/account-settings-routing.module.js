import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../layout/main-layout/main-layout.component';
import { AccountSettingsComponent } from './account-settings.component';
var routes = [
    {
        path: 'account-settings',
        component: MainLayoutComponent,
        children: [
            { path: '', component: AccountSettingsComponent }
        ]
    }
];
var AccountSettingsRoutingModule = /** @class */ (function () {
    function AccountSettingsRoutingModule() {
    }
    AccountSettingsRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], AccountSettingsRoutingModule);
    return AccountSettingsRoutingModule;
}());
export { AccountSettingsRoutingModule };
//# sourceMappingURL=account-settings-routing.module.js.map