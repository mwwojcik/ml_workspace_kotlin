import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AplikacjaKreatorRegulComponent } from './aplikacja-kreator-regul.component';

describe('AplikacjaKreatorRegulComponent', () => {
  let component: AplikacjaKreatorRegulComponent;
  let fixture: ComponentFixture<AplikacjaKreatorRegulComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AplikacjaKreatorRegulComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AplikacjaKreatorRegulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
