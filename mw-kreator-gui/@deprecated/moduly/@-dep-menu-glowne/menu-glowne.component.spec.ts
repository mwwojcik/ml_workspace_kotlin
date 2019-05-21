import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuGlowneComponent } from './menu-glowne.component';

describe('MenuGlowneComponent', () => {
  let component: MenuGlowneComponent;
  let fixture: ComponentFixture<MenuGlowneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuGlowneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuGlowneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
