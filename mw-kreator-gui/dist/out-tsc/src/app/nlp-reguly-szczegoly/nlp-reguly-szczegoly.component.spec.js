import { async, TestBed } from '@angular/core/testing';
import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly.component';
describe('NlpRegulySzczegolyComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [NlpRegulySzczegolyComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(NlpRegulySzczegolyComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=nlp-reguly-szczegoly.component.spec.js.map