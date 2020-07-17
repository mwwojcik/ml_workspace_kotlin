import { async, TestBed } from '@angular/core/testing';
import { OprojekcieComponent } from './oprojekcie.component';
describe('OprojekcieComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [OprojekcieComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(OprojekcieComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=oprojekcie.component.spec.js.map