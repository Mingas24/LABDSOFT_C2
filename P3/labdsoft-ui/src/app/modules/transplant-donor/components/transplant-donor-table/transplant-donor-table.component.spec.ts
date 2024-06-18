import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantDonorTableComponent } from './transplant-donor-table.component';

describe('TransplantDonorTableComponent', () => {
  let component: TransplantDonorTableComponent;
  let fixture: ComponentFixture<TransplantDonorTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantDonorTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantDonorTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
