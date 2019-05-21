import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NlpRegulyListaComponent } from './nlp-reguly-lista.component';

describe('NlpRegulyListaComponent', () => {
  let component: NlpRegulyListaComponent;
  let fixture: ComponentFixture<NlpRegulyListaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NlpRegulyListaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NlpRegulyListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
