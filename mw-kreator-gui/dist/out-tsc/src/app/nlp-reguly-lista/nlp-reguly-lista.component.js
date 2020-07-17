import * as tslib_1 from "tslib";
import { Component } from '@angular/core';
import { RegulyService } from '../reguly.service';
var NlpRegulyListaComponent = /** @class */ (function () {
    function NlpRegulyListaComponent(regulyUsluga) {
        this.regulyUsluga = regulyUsluga;
    }
    NlpRegulyListaComponent.prototype.getReguly = function () {
        return this.reguly;
    };
    NlpRegulyListaComponent.prototype.ngOnInit = function () {
        this.reguly = this.regulyUsluga.podajReguly();
    };
    NlpRegulyListaComponent = tslib_1.__decorate([
        Component({
            selector: 'app-nlp-reguly-lista',
            templateUrl: './nlp-reguly-lista.component.html',
            styleUrls: ['./nlp-reguly-lista.component.css']
        }),
        tslib_1.__metadata("design:paramtypes", [RegulyService])
    ], NlpRegulyListaComponent);
    return NlpRegulyListaComponent;
}());
export { NlpRegulyListaComponent };
//# sourceMappingURL=nlp-reguly-lista.component.js.map