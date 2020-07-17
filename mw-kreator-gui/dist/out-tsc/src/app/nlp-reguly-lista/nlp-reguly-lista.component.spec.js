import { async, TestBed } from '@angular/core/testing';
import { NlpRegulyListaComponent } from './nlp-reguly-lista.component';
describe('NlpRegulyListaComponent', function () {
    var component;
    var fixture;
    beforeEach(async(function () {
        TestBed.configureTestingModule({
            declarations: [NlpRegulyListaComponent]
        })
            .compileComponents();
    }));
    beforeEach(function () {
        fixture = TestBed.createComponent(NlpRegulyListaComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });
    it('should create', function () {
        expect(component).toBeTruthy();
    });
});
//# sourceMappingURL=nlp-reguly-lista.component.spec.js.map