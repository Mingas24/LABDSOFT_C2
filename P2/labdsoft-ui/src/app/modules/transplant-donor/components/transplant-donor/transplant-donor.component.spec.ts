import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantDonorComponent } from './transplant-donor.component';

describe('TransplantDonorComponent', () => {
  let component: TransplantDonorComponent;
  let fixture: ComponentFixture<TransplantDonorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantDonorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantDonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
