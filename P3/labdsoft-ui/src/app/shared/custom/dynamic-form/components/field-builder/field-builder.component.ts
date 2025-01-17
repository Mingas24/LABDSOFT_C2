import { ModeEnum } from './../../enums/mode.enum';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'field-builder',
  templateUrl: './field-builder.component.html',
  styleUrls: ['./field-builder.component.scss']
})
export class FieldBuilderComponent {
  @Input() field: any;
  @Input() form: any;
  @Input() mode!: ModeEnum;

  get isValid() {
    return this.form.controls[this.field.name].valid;
  }
  get isDirty() {
    return this.form.controls[this.field.name].dirty;
  }

  constructor() {}
}
