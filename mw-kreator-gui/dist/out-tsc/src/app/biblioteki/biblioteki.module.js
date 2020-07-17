import * as tslib_1 from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BibliotekiRoutingModule } from './biblioteki-routing.module';
import { BibliotekiComponent } from './biblioteki.component';
var BibliotekiModule = /** @class */ (function () {
    function BibliotekiModule() {
    }
    BibliotekiModule = tslib_1.__decorate([
        NgModule({
            imports: [
                CommonModule,
                BibliotekiRoutingModule
            ],
            declarations: [BibliotekiComponent]
        })
    ], BibliotekiModule);
    return BibliotekiModule;
}());
export { BibliotekiModule };
//# sourceMappingURL=biblioteki.module.js.map