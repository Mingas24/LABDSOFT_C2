import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DynamicTableComponent } from './components/dynamic-table/dynamic-table.component';
import { TableActionsComponent } from './components/table-actions/table-actions.component';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from "@angular/material/icon";
import { MatIconRegistry } from "@angular/material/icon";
import { MaterialModule } from '../../material.module';
import { ObjectValuePipe } from '../../object-value.pipe';



@NgModule({
  declarations: [
    DynamicTableComponent,
    TableActionsComponent,
    ObjectValuePipe
  ],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    MatIconModule,
  ],
  exports:[
    DynamicTableComponent
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class DynamicTableModule { }
