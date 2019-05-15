import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZawartoscStatycznaComponent } from './zawartosc-statyczna.component';

describe('ZawartoscStatycznaComponent', () => {
  let component: ZawartoscStatycznaComponent;
  let fixture: ComponentFixture<ZawartoscStatycznaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZawartoscStatycznaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZawartoscStatycznaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
