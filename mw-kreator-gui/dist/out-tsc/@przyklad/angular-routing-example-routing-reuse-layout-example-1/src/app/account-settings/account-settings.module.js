import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountSettingsRoutingModule } from './account-settings-routing.module';
import { AccountSettingsComponent } from './account-settings.component';
var AccountSettingsModule = /** @class */ (function () {
    function AccountSettingsModule() {
    }
    AccountSettingsModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                AccountSettingsRoutingModule
            ],
            declarations: [AccountSettingsComponent]
        })
    ], AccountSettingsModule);
    return AccountSettingsModule;
}());
export { AccountSettingsModule };
//# sourceMappingURL=account-settings.module.js.map