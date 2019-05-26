import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UkladGlownyAppWejscieComponent } from './uklad-glowny-app-wejscie.component';

describe('UkladGlownyAppWejscieComponent', () => {
  let component: UkladGlownyAppWejscieComponent;
  let fixture: ComponentFixture<UkladGlownyAppWejscieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UkladGlownyAppWejscieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UkladGlownyAppWejscieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
