import * as tslib_1 from "tslib";
import { Injectable } from '@angular/core';
import SampleJson from './reguly.json';
var RegulyService = /** @class */ (function () {
    function RegulyService() {
        this.reguly = SampleJson;
    }
    RegulyService.prototype.podajReguly = function () {
        return this.reguly;
    };
    RegulyService.prototype.podajRegulePoKodzie = function (aKod) {
        //var result = new Map(SampleJson.map(i => [i.kod, i]));
        return this.reguly[1]; //result.get(aKod);
    };
    RegulyService = tslib_1.__decorate([
        Injectable({
            providedIn: 'root'
        }),
        tslib_1.__metadata("design:paramtypes", [])
    ], RegulyService);
    return RegulyService;
}());
export { RegulyService };
//# sourceMappingURL=reguly.service.js.map