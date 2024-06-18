import { OrganWastageFormComponent } from './components/organ-wastage-form/organ-wastage-form.component';
import { OrganWastageComponent } from './components/organ-wastage/organ-wastage.component';
import { DynamicFormModule } from './../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: OrganWastageComponent
  }
];

@NgModule({
  declarations: [
    OrganWastageComponent,
    OrganWastageFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    RouterModule.forChild(routes)
  ],
  exports: [OrganWastageComponent]
})
export class OrganWastageModule {}
