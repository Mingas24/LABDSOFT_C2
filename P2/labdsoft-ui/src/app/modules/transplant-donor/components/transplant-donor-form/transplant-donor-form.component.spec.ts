import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantDonorFormComponent } from './transplant-donor-form.component';

describe('TransplantDonorFormComponent', () => {
  let component: TransplantDonorFormComponent;
  let fixture: ComponentFixture<TransplantDonorFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantDonorFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantDonorFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
