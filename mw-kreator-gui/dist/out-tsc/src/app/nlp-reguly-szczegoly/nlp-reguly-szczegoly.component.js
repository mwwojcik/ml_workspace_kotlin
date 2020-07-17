import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RegulyService } from '../reguly.service';
var NlpRegulySzczegolyComponent = /** @class */ (function () {
    function NlpRegulySzczegolyComponent(route, regulyUsluga) {
        this.route = route;
        this.regulyUsluga = regulyUsluga;
    }
    NlpRegulySzczegolyComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.queryParams.subscribe(function (params) {
            _this.kod = params['kod'];
            _this.regula = _this.regulyUsluga.podajRegulePoKodzie(_this.kod);
        });
    };
    NlpRegulySzczegolyComponent.prototype.getKod = function () {
        console.log("getKod");
        return this.kod;
    };
    NlpRegulySzczegolyComponent.prototype.getRegula = function () {
        return this.regula;
    };
    NlpRegulySzczegolyComponent = tslib_1.__decorate([
        Component({
            selector: 'app-nlp-reguly-szczegoly',
            templateUrl: './nlp-reguly-szczegoly.component.html',
            styleUrls: ['./nlp-reguly-szczegoly.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [ActivatedRoute, RegulyService])
    ], NlpRegulySzczegolyComponent);
    return NlpRegulySzczegolyComponent;
}());
export { NlpRegulySzczegolyComponent };
//# sourceMappingURL=nlp-reguly-szczegoly.component.js.map