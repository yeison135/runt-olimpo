import { TestBed } from '@angular/core/testing';

import { OlimpoServiceService } from './olimpo-service.service';

describe('OlimpoServiceService', () => {
  let service: OlimpoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OlimpoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
