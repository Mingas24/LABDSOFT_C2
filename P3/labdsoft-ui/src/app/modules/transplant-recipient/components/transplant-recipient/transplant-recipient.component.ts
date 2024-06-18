
import { Component } from '@angular/core';
import { TransplantRecipientService } from '../../services/transplant-recipient.service';
import { TransplantRecipientFormResult } from '../../models/transplant-recipient-form-result.model';
import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';

@Component({
  selector: 'app-transplant-recipient',
  templateUrl: './transplant-recipient.component.html',
  styleUrls: ['./transplant-recipient.component.css']
})
export class TransplantRecipientComponent {
  mode!: ModeEnum;

  constructor(private transplantRecipientService: TransplantRecipientService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitTransplantRecipient(
    transplantRecipientFormResult: TransplantRecipientFormResult
  ): void {
    this.transplantRecipientService
      .postTransplantRecipient(transplantRecipientFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
