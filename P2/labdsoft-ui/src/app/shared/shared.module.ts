import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material.module';
import { DynamicTableComponent } from './custom/dynamic-table/components/dynamic-table/dynamic-table.component';
import { DynamicFormComponent } from './custom/dynamic-form/components/dynamic-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ObjectValuePipe } from './object-value.pipe';



@NgModule({
  declarations: [
    DynamicFormComponent,
    DynamicTableComponent,
    ObjectValuePipe
  ],
  imports: [
    CommonModule,
    MaterialModule,
    HttpClientModule
  ],
  exports: [
    MaterialModule,
    HttpClientModule,
    DynamicFormComponent,
    DynamicTableComponent
  ]
})
export class SharedModule { }
