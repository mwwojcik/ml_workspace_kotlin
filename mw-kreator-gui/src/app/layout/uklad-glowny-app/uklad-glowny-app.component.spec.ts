import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UkladGlownyAppComponent } from './uklad-glowny-app.component';

describe('UkladGlownyAppComponent', () => {
  let component: UkladGlownyAppComponent;
  let fixture: ComponentFixture<UkladGlownyAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UkladGlownyAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UkladGlownyAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
