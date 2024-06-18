import { TestBed } from '@angular/core/testing';

import { HealthActivityTrackerService } from './health-activity-tracker.service';

describe('HealthActivityTrackerService', () => {
  let service: HealthActivityTrackerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HealthActivityTrackerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
