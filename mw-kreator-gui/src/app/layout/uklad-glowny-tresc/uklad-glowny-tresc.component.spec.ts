import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UkladGlownyTrescComponent } from './uklad-glowny-tresc.component';

describe('UkladGlownyTrescComponent', () => {
  let component: UkladGlownyTrescComponent;
  let fixture: ComponentFixture<UkladGlownyTrescComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UkladGlownyTrescComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UkladGlownyTrescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
