import { async, TestBed } from '@angular/core/testing';
import { ZawartoscStatycznaComponent } from './zawartosc-statyczna.component';
describe('ZawartoscStatycznaComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [ZawartoscStatycznaComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(ZawartoscStatycznaComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=zawartosc-statyczna.component.spec.js.map