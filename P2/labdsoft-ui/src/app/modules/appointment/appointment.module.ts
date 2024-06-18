import { AppointmentFormComponent } from './components/appointment-form/appointment-form.component';
import { AppointmentComponent } from './components/appointment/appointment.component';
import { DynamicFormModule } from './../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AppointmentComponent
  }
];

@NgModule({
  declarations: [
    AppointmentComponent,
    AppointmentFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    RouterModule.forChild(routes)
  ],
  exports: [AppointmentComponent]
})
export class AppointmentModule {}
