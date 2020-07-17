import * as tslib_1 from "tslib";
import { Component, Input } from '@angular/core';
import { RegulaBiznesowa } from '../model';
var AppRegulaComponent = /** @class */ (function () {
    function AppRegulaComponent() {
    }
    AppRegulaComponent.prototype.ngOnInit = function () {
    };
    var _a;
    tslib_1.__decorate([
        Input(),
        tslib_1.__metadata("design:type", typeof (_a = typeof RegulaBiznesowa !== "undefined" && RegulaBiznesowa) === "function" ? _a : Object)
    ], AppRegulaComponent.prototype, "regula", void 0);
    AppRegulaComponent = tslib_1.__decorate([
        Component({
            selector: 'app-app-regula',
            templateUrl: './app-regula.component.html',
            styleUrls: ['./app-regula.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], AppRegulaComponent);
    return AppRegulaComponent;
}());
export { AppRegulaComponent };
//# sourceMappingURL=app-regula.component.js.map