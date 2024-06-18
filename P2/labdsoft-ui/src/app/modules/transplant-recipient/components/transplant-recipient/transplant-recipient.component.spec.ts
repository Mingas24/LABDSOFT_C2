/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TransplantRecipientComponent } from './transplant-recipient.component';

describe('TransplantRecipientComponent', () => {
  let component: TransplantRecipientComponent;
  let fixture: ComponentFixture<TransplantRecipientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [TransplantRecipientComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransplantRecipientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
