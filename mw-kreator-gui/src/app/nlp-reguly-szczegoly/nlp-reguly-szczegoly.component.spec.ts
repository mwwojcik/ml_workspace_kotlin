import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulySzczegolyComponent } from './nlp-reguly-szczegoly.component';

describe('NlpRegulySzczegolyComponent', () => {
  let component: NlpRegulySzczegolyComponent;
  let fixture: ComponentFixture<NlpRegulySzczegolyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulySzczegolyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulySzczegolyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
