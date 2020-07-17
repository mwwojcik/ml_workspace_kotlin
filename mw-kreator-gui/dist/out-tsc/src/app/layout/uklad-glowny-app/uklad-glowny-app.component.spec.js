import { async, TestBed } from '@angular/core/testing';
import { UkladGlownyAppComponent } from './uklad-glowny-app.component';
describe('UkladGlownyAppComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [UkladGlownyAppComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(UkladGlownyAppComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=uklad-glowny-app.component.spec.js.map