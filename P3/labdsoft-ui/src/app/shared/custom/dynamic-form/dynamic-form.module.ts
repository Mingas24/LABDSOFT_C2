import { DynamicFormComponent } from './components/dynamic-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { FieldBuilderComponent } from './components/field-builder/field-builder.component';
import { DropdownComponent } from './components/field-types/dropdown/dropdown.component';
import { TextComponent } from './components/field-types/text/text.component';
import { DateComponent } from './components/field-types/date/date.component';
import { ReadonlyComponent } from './components/field-types/readonly/readonly.component';
import { CheckboxComponent } from './components/field-types/checkbox/checkbox.component';

@NgModule({
  declarations: [
    DynamicFormComponent,
    TextComponent,
    FieldBuilderComponent,
    DropdownComponent,
    DateComponent,
    ReadonlyComponent,
    CheckboxComponent
  ],
  imports: [CommonModule, ReactiveFormsModule],
  exports: [DynamicFormComponent]
})
export class DynamicFormModule {}
