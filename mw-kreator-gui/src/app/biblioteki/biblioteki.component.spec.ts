import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BibliotekiComponent } from './biblioteki.component';

describe('BibliotekiComponent', () => {
  let component: BibliotekiComponent;
  let fixture: ComponentFixture<BibliotekiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BibliotekiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BibliotekiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
