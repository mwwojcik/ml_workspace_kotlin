import { async, TestBed } from '@angular/core/testing';
import { MenuGlowneComponent } from './menu-glowne.component';
describe('MenuGlowneComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [MenuGlowneComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(MenuGlowneComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=menu-glowne.component.spec.js.map