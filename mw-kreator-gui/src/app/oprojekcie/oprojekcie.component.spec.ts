import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OprojekcieComponent } from './oprojekcie.component';

describe('OprojekcieComponent', () => {
  let component: OprojekcieComponent;
  let fixture: ComponentFixture<OprojekcieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OprojekcieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OprojekcieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
