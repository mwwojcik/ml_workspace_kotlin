import { async, TestBed } from '@angular/core/testing';
import { AppListaRegulComponent } from './app-lista-regul.component';
describe('AppListaRegulComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [AppListaRegulComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(AppListaRegulComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=app-lista-regul.component.spec.js.map