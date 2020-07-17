import { async, TestBed } from '@angular/core/testing';
import { UkladGlownyTrescComponent } from './uklad-glowny-tresc.component';
describe('UkladGlownyTrescComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [UkladGlownyTrescComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(UkladGlownyTrescComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=uklad-glowny-tresc.component.spec.js.map