import { ModeEnum } from './../enums/mode.enum';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import * as _ from 'lodash';


@Component({
  selector: 'dynamic-form',
  templateUrl: './dynamic-form.component.html',
  styleUrls: ['./dynamic-form.component.scss']
})


export class DynamicFormComponent implements OnInit {
  @Output() onSubmit = new EventEmitter();
  @Input() fields: any[] = [];

  /* Mode.NEW = Novo registo, dá para introduzir dados nos fields
   *  Mode.SHOW_INFO = Mostra um registo existente, com a possibilidade de editar após o click no botão "EDITAR"
   */
  @Input() mode!: ModeEnum;
  @Input() title!: string;
  @Input() showReturnBtn!: boolean;
  ModeEnum = ModeEnum;
  editMode: boolean = false;
  backupForm!: FormGroup;
  form!: FormGroup;

  constructor() {}

  ngOnInit(): void {
    let fieldsCtrls = {} as any;
    for (let f of this.fields) {
      if (f.type != 'checkbox') {
        fieldsCtrls[f.name] = new FormControl(
          f.value || '',
          f.required && Validators.required
        );
      } else {
        let opts = {} as any;
        for (let opt of f.options) {
          opts[opt.key] = new FormControl(opt.value);
        }
        fieldsCtrls[f.name] = new FormGroup(opts);
      }
    }
    this.form = new FormGroup(fieldsCtrls);
    this.backupForm = _.cloneDeep(this.form);

    if (this.mode === ModeEnum.SHOW_INFO) {
      this.form.disable();
    }
  }

  toggleEditMode(): void {
    this.editMode = !this.editMode;
    if (this.editMode) {
      this.form.enable();
    } else {
      this.form.disable();
      this.onCancelEdition();
    }
  }

  onCancelEdition(): void {
    this.form = _.cloneDeep(this.backupForm);
  }

  return(){
    if(window.location.toString() == 'http://localhost:4200/transplant-recipients'){
      window.location.replace('/transplant-recipients/list')
    } else if(window.location.toString() == 'http://localhost:4200/transplant-recipients/edit'){
      window.location.replace('/transplant-recipients/list')
    } else if(window.location.toString() == 'http://localhost:4200/transplant-donors'){
      window.location.replace('/transplant-donors/list')
    } else if(window.location.toString() == 'http://localhost:4200/adherents'){
      window.location.replace('adherents/list')
    }
  }
}
