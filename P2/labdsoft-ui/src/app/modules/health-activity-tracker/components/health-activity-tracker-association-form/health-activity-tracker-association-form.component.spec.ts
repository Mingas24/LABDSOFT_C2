import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthActivityTrackerAssociationFormComponent } from './health-activity-tracker-association-form.component';

describe('HealthActivityTrackerAssociationFormComponent', () => {
  let component: HealthActivityTrackerAssociationFormComponent;
  let fixture: ComponentFixture<HealthActivityTrackerAssociationFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthActivityTrackerAssociationFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HealthActivityTrackerAssociationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
