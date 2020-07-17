import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrationRoutingModule } from './registration-routing.module';
import { RegistrationComponent } from './registration.component';
var RegistrationModule = /** @class */ (function () {
    function RegistrationModule() {
    }
    RegistrationModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                RegistrationRoutingModule
            ],
            declarations: [RegistrationComponent]
        })
    ], RegistrationModule);
    return RegistrationModule;
}());
export { RegistrationModule };
//# sourceMappingURL=registration.module.js.map