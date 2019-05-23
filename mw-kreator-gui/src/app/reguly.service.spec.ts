import { TestBed } from '@angular/core/testing';

import { RegulyService } from './reguly.service';

describe('RegulyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegulyService = TestBed.get(RegulyService);
    expect(service).toBeTruthy();
  });
});
