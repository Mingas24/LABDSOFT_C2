import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantRecipientEditFormComponent } from './transplant-recipient-edit-form.component';

describe('TransplantRecipientEditFormComponent', () => {
  let component: TransplantRecipientEditFormComponent;
  let fixture: ComponentFixture<TransplantRecipientEditFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantRecipientEditFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantRecipientEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
