import { async, TestBed } from '@angular/core/testing';
import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje.component';
describe('NlpRegulyAkcjeComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [NlpRegulyAkcjeComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(NlpRegulyAkcjeComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=nlp-reguly-akcje.component.spec.js.map