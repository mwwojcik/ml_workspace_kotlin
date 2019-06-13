import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulyKodComponent } from './nlp-reguly-kod.component';

describe('NlpRegulyKodComponent', () => {
  let component: NlpRegulyKodComponent;
  let fixture: ComponentFixture<NlpRegulyKodComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulyKodComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulyKodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
