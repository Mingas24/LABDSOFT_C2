import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantRecipientTableComponent } from './transplant-recipient-table.component';

describe('TransplantRecipientTableComponent', () => {
  let component: TransplantRecipientTableComponent;
  let fixture: ComponentFixture<TransplantRecipientTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantRecipientTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantRecipientTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
