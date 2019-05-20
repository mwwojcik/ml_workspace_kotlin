import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppRegulaComponent } from './app-regula.component';

describe('AppRegulaComponent', () => {
  let component: AppRegulaComponent;
  let fixture: ComponentFixture<AppRegulaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppRegulaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppRegulaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
