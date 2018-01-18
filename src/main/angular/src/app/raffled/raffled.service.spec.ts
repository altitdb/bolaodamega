import { TestBed, inject } from '@angular/core/testing';

import { RaffledService } from './raffled.service';

describe('RaffledService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RaffledService]
    });
  });

  it('should be created', inject([RaffledService], (service: RaffledService) => {
    expect(service).toBeTruthy();
  }));
});
