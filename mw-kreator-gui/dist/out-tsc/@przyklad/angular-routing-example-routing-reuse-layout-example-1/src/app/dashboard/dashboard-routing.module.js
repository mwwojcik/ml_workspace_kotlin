import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from '../layout/main-layout/main-layout.component';
import { DashboardComponent } from './dashboard.component';
var routes = [
    {
        path: 'dashboard',
        component: MainLayoutComponent,
        children: [
            { path: '', component: DashboardComponent }
        ]
    }
];
var DashboardRoutingModule = /** @class */ (function () {
    function DashboardRoutingModule() {
    }
    DashboardRoutingModule = tslib_1.__decorate([
        NgModule({
            imports: [RouterModule.forChild(routes)],
            exports: [RouterModule]
        })
    ], DashboardRoutingModule);
    return DashboardRoutingModule;
}());
export { DashboardRoutingModule };
//# sourceMappingURL=dashboard-routing.module.js.map