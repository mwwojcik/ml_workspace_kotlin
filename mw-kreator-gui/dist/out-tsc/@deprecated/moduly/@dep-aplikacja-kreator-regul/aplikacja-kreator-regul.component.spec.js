import { async, TestBed } from '@angular/core/testing';
import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul.component';
describe('AplikacjaKreatorRegulComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [AplikacjaKreatorRegulComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(AplikacjaKreatorRegulComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=aplikacja-kreator-regul.component.spec.js.map