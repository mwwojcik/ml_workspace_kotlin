import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
var DashboardModule = /** @class */ (function () {
    function DashboardModule() {
    }
    DashboardModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                DashboardRoutingModule
            ],
            declarations: [DashboardComponent]
        })
    ], DashboardModule);
    return DashboardModule;
}());
export { DashboardModule };
//# sourceMappingURL=dashboard.module.js.map