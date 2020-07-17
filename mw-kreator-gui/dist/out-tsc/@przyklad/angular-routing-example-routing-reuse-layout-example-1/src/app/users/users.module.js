import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersRoutingModule } from './users-routing.module';
import { UsersComponent } from './users.component';
var UsersModule = /** @class */ (function () {
    function UsersModule() {
    }
    UsersModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                UsersRoutingModule
            ],
            declarations: [UsersComponent]
        })
    ], UsersModule);
    return UsersModule;
}());
export { UsersModule };
//# sourceMappingURL=users.module.js.map