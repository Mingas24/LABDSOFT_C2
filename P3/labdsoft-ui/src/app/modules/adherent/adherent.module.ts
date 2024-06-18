import { DynamicTableModule } from './../../shared/custom/dynamic-table/dynamic-table.module';
import { AdherentTableComponent } from './components/adherent-table/adherent-table.component';
import { AdherentRoutingModule } from './adherent.routing.module';
import { AdherentFormComponent } from './components/adherent-form/adherent-form.component';
import { AdherentComponent } from './components/adherent/adherent.component';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'src/app/shared/material.module';
import { DynamicFormModule } from 'src/app/shared/custom/dynamic-form/dynamic-form.module';
@NgModule({
    declarations: [
        AdherentComponent,
        AdherentFormComponent,
        AdherentTableComponent
    ],
    imports: [
      AdherentRoutingModule,
      CommonModule,
      ReactiveFormsModule,
      DynamicFormModule,
      MaterialModule,
      DynamicTableModule
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AdherentModule { }
