import { TransplantRecipientEditFormComponent } from './components/transplant-recipient-edit-form/transplant-recipient-edit-form.component';
import { TransplantRecipientFormComponent } from './components/transplant-recipient-form/transplant-recipient-form.component';
import { DynamicFormModule } from './../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { DynamicTableModule } from 'src/app/shared/custom/dynamic-table/dynamic-table.module';
import { MaterialModule } from 'src/app/shared/material.module';
import { TransplantRecipientComponent } from './components/transplant-recipient/transplant-recipient.component';
import { TransplantRecipientEditComponent } from './components/transplant-recipient-edit/transplant-recipient-edit.component';
import { TransplantRecipientTableComponent } from './components/transplant-recipient-table/transplant-recipient-table.component';
import { TransplantRecipientRoutingModule } from './transplant-recipient.routing.module';

const routes: Routes = [
  {
    path: '',
    component: TransplantRecipientComponent
  }
];

@NgModule({
  declarations: [
    TransplantRecipientComponent,
    TransplantRecipientFormComponent,
    TransplantRecipientTableComponent,
    TransplantRecipientEditComponent,
    TransplantRecipientEditFormComponent
  ],
  imports: [
    TransplantRecipientRoutingModule,
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    MaterialModule,
    DynamicTableModule,
  ],
  exports: [TransplantRecipientComponent]
})
export class TransplantRecipientModule {}
