import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulyWejscieComponent } from './nlp-reguly-wejscie.component';

describe('NlpRegulyWejscieComponent', () => {
  let component: NlpRegulyWejscieComponent;
  let fixture: ComponentFixture<NlpRegulyWejscieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulyWejscieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulyWejscieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
