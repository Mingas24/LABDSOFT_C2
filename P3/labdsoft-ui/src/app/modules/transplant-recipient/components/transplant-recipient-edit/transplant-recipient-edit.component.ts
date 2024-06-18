import { TransplantRecipientService } from './../../services/transplant-recipient.service';
import { TransplantRecipientEditFormAssembler } from './../../assembler/transplant-recipient-edit-form.assembler';
import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TransplantRecipientFormResult } from '../../models/transplant-recipient-form-result.model';
import { timeout } from 'rxjs';
import { TransplantRecipientEditFormResult } from '../../models/transplant-recipient-edit-form-result.model';

@Component({
  selector: 'app-transplant-recipient-edit',
  templateUrl: './transplant-recipient-edit.component.html',
  styleUrls: ['./transplant-recipient-edit.component.scss'],
  providers: [TransplantRecipientEditFormAssembler]
})
export class TransplantRecipientEditComponent{
  mode!: ModeEnum;


  constructor(private transplantRecipientService: TransplantRecipientService) {
      this.mode = ModeEnum.NEW;
     }

     onSubmitTransplantRecipientEdit(
      transplantRecipientEditFormResult: TransplantRecipientEditFormResult): void {
      this.transplantRecipientService
        .editTransplantRecipientStateOfUrgency(transplantRecipientEditFormResult)
        .subscribe((res) => {
          console.log(res);
        });
    }




  
}
