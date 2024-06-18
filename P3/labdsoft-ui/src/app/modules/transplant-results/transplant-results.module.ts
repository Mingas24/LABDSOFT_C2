import { TransplantResultsTableComponent } from './components/transplant-results-table/transplant-results-table.component';
import { TransplantResultsFormComponent } from './components/transplant-results-form/transplant-results-form.component';
import { MaterialModule } from '../../shared/material.module';
import { DynamicTableModule } from './../../shared/custom/dynamic-table/dynamic-table.module';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { DynamicFormModule } from 'src/app/shared/custom/dynamic-form/dynamic-form.module';
import { TransplantResultsComponent } from './components/transplant-results/transplant-results.component';
import { TransplantResultsRoutingModule } from './transplant-results.routing.module';

@NgModule({
  declarations: [
    TransplantResultsComponent,
    TransplantResultsFormComponent,
    TransplantResultsTableComponent,
    ],
  imports: [
    TransplantResultsRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    DynamicTableModule,
    DynamicFormModule,
    MaterialModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TransplantResultsModule {}
