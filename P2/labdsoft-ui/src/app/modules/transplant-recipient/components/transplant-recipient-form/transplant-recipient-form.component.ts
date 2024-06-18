import { Component, Input, OnInit, Output, EventEmitter, Version, ViewChild, ElementRef } from '@angular/core';
import { ModeEnum } from 'src/app/shared/custom/dynamic-form/enums/mode.enum';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { UserService } from 'src/app/shared/services/user.service';
import { TransplantRecipientFormAssembler } from '../../assembler/transplant-recipient-form.assembler';
import { TransplantRecipientFormResult } from '../../models/transplant-recipient-form-result.model';

@Component({
  selector: 'app-transplant-recipient-form',
  templateUrl: './transplant-recipient-form.component.html',
  styleUrls: ['./transplant-recipient-form.component.scss'],
  providers: [TransplantRecipientFormAssembler]
})
export class TransplantRecipientFormComponent implements OnInit { 

  @Input() transplantRecipient!: string;
  @Input() mode!: ModeEnum;
  @Output() onSubmitTransplantRecipient = new EventEmitter();
  isLoading: boolean = true;

  constructor(
    private userService: UserService,
    private uiLoaderService: UiLoaderService,
    public transplantRecipientFormAssembler: TransplantRecipientFormAssembler
  ) {}

  ngOnInit(): void {
    this.initTransplantRecipientForm();
  }

  initTransplantRecipientForm() {
    this.transplantRecipientFormAssembler.FORM_SPECIFICATION.filter(
      (x) => x.name === 'registeredBy'
    )[0].value = this.userService.user.username;

    this.uiLoaderService.getTransplantRecipientFormData().subscribe((res) => {
      this.transplantRecipientFormAssembler.FORM_SPECIFICATION.filter(
        (x) => x.type === 'dropdown' || x.type === 'checkbox'
      ).forEach((x) => {
        if (x.mappingVariable) {
          x.options = (res.responseObject as any)[x.mappingVariable].map(
            (x: string) => {
              return {
                key: x,
                label: x
              };
            }
          );
        }
      });

      this.isLoading = false;
    });

    this.userService.getUsersByRole('MEDICO').subscribe((res) => {
      this.transplantRecipientFormAssembler.FORM_SPECIFICATION.filter(
        (x) => x.name === 'assistentDoctor'
      )[0].options = (res.responseObject as []).map((x) => {
        return { key: x['username'], label: x['username'] };
      });
    });
  }

  onSubmitForm(event: any) {
    let transplantRecipientFormResult: TransplantRecipientFormResult = event;
    for (const prop in transplantRecipientFormResult) {
      if (prop === 'organsInNeed' || prop === 'hlaTypes') {
        let tempArray: string[] = [];
        for (const prop2 in transplantRecipientFormResult[prop]) {
          if ((transplantRecipientFormResult[prop] as any)[prop2]) {
            tempArray.push(prop2);
          }
        }
        transplantRecipientFormResult[prop] = tempArray;
      }
    }
    this.onSubmitTransplantRecipient.emit(transplantRecipientFormResult);
    window.location.replace('/transplant-recipients/list')

  }
}
/*





}*/
