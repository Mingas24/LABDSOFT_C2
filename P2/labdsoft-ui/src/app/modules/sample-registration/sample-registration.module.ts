import { SampleRegistrationFormComponent } from './components/sample-registration-form/sample-registration-form.component';
import { SampleRegistrationComponent } from './components/sample-registration/sample-registration.component';
import { DynamicFormModule } from './../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: SampleRegistrationComponent
  }
];

@NgModule({
  declarations: [
    SampleRegistrationComponent,
    SampleRegistrationFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    RouterModule.forChild(routes)
  ],
  exports: [SampleRegistrationComponent]
})
export class SampleRegistrationModule {}
