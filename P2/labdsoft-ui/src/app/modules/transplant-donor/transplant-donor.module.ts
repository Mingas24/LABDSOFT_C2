import { TransplantDonorTableComponent } from './components/transplant-donor-table/transplant-donor-table.component';
import { TransplantDonorFormComponent } from './components/transplant-donor-form/transplant-donor-form.component';
import { MaterialModule } from '../../shared/material.module';
import { DynamicTableModule } from './../../shared/custom/dynamic-table/dynamic-table.module';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { DynamicFormModule } from 'src/app/shared/custom/dynamic-form/dynamic-form.module';
import { TransplantDonorComponent } from './components/transplant-donor/transplant-donor.component';
import { TransplantDonorRoutingModule } from './transplant-donor.routing.module';

@NgModule({
  declarations: [
    TransplantDonorComponent,
    TransplantDonorFormComponent,
    TransplantDonorTableComponent,
    ],
  imports: [
    TransplantDonorRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    DynamicTableModule,
    DynamicFormModule,
    MaterialModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TransplantDonorModule {}
