import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuZmianaTrybuAppComponent } from './menu-zmiana-trybu-app.component';

describe('MenuZmianaTrybuAppComponent', () => {
  let component: MenuZmianaTrybuAppComponent;
  let fixture: ComponentFixture<MenuZmianaTrybuAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuZmianaTrybuAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuZmianaTrybuAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
