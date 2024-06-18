import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantRecipientFormComponent } from './transplant-recipient-form.component';

describe('TransplantRecipientComponent', () => {
  let component: TransplantRecipientFormComponent;
  let fixture: ComponentFixture<TransplantRecipientFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TransplantRecipientFormComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(TransplantRecipientFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
