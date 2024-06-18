import { HealthActivityTrackerRoutingModule } from './health-activity-tracker.routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HealthActivityTrackerAssociationFormComponent } from './components/health-activity-tracker-association-form/health-activity-tracker-association-form.component';
import { HealthActivityTrackerAssociationComponent } from './components/health-activity-tracker-association/health-activity-tracker-association.component';
import { DynamicFormModule } from 'src/app/shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    HealthActivityTrackerAssociationFormComponent,
    HealthActivityTrackerAssociationComponent
  ],
  imports: [
    HealthActivityTrackerRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
  ]
})
export class HealthActivityTrackerModule { }
