import { TestBed } from '@angular/core/testing';

import { TransplantRecipientService } from './transplant-recipient.service';

describe('TransplantRecipientService', () => {
  let service: TransplantRecipientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransplantRecipientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
