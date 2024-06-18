import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantRecipientEditComponent } from './transplant-recipient-edit.component';

describe('TransplantRecipientEditComponent', () => {
  let component: TransplantRecipientEditComponent;
  let fixture: ComponentFixture<TransplantRecipientEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantRecipientEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantRecipientEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
