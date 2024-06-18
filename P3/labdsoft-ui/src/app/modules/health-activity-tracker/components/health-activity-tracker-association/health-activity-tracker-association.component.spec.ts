import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthActivityTrackerAssociationComponent } from './health-activity-tracker-association.component';

describe('HealthActivityTrackerAssociationComponent', () => {
  let component: HealthActivityTrackerAssociationComponent;
  let fixture: ComponentFixture<HealthActivityTrackerAssociationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthActivityTrackerAssociationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HealthActivityTrackerAssociationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
