import { VitalSignsTableComponent } from './components/vital-signs-table/vital-signs-table.component';
import { MaterialModule } from '../../shared/material.module';
import { DynamicTableModule } from '../../shared/custom/dynamic-table/dynamic-table.module';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { DynamicFormModule } from 'src/app/shared/custom/dynamic-form/dynamic-form.module';
import { VitalSignsRoutingModule } from './vital-signs.routing.module';
import { VitalSignsComponent } from './components/vital-signs/vital-signs.component';
import { VitalSignsFormComponent } from './components/vital-signs-form/vital-signs-form.component';

@NgModule({
  declarations: [
    VitalSignsComponent,
    VitalSignsFormComponent,
    VitalSignsTableComponent,
    ],
  imports: [
    VitalSignsRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    DynamicTableModule,
    DynamicFormModule,
    MaterialModule,
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class VitalSignsModule {}
