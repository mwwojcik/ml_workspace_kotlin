import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulyListaInfoComponent } from './nlp-reguly-lista-info.component';

describe('NlpRegulyListaInfoComponent', () => {
  let component: NlpRegulyListaInfoComponent;
  let fixture: ComponentFixture<NlpRegulyListaInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulyListaInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulyListaInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
