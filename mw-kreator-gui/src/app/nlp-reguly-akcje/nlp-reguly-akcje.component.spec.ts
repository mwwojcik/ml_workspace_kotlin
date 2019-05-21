import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulyAkcjeComponent } from './nlp-reguly-akcje.component';

describe('NlpRegulyAkcjeComponent', () => {
  let component: NlpRegulyAkcjeComponent;
  let fixture: ComponentFixture<NlpRegulyAkcjeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulyAkcjeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulyAkcjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
