import { async, TestBed } from '@angular/core/testing';
import { BibliotekiComponent } from './biblioteki.component';
describe('BibliotekiComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [BibliotekiComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(BibliotekiComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=biblioteki.component.spec.js.map