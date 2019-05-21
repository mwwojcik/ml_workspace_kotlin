import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppListaRegulComponent } from './app-lista-regul.component';

describe('AppListaRegulComponent', () => {
  let component: AppListaRegulComponent;
  let fixture: ComponentFixture<AppListaRegulComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppListaRegulComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppListaRegulComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
