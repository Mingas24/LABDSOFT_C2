import { TransplantRecipientEditFormAssembler } from './../../assembler/transplant-recipient-edit-form.assembler';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TransplantRecipientEditFormResult } from '../../models/transplant-recipient-edit-form-result.model';
import { ModeEnum } from 'src/app/shared/custom/dynamic-form/enums/mode.enum';

@Component({
  selector: 'app-transplant-recipient-edit-form',
  templateUrl: './transplant-recipient-edit-form.component.html',
  styleUrls: ['./transplant-recipient-edit-form.component.scss']
})
export class TransplantRecipientEditFormComponent implements OnInit {

  @Input() transplantRecipient!: string;
  @Input() mode!: ModeEnum;
  @Output() onSubmitTransplantRecipientEdit = new EventEmitter();
  isLoading: boolean = true;

  constructor(
    private uiLoaderService: UiLoaderService, public transplantRecipientEditFormAssembler: TransplantRecipientEditFormAssembler
  ) { }

  ngOnInit(): void {
    this.initTransplantRecipientEditForm();
  }

  initTransplantRecipientEditForm(){
    this.uiLoaderService.getTransplantRecipientEditFormData().subscribe((res) => {
      this.transplantRecipientEditFormAssembler.FORM_SPECIFICATION.filter(
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
      }

  onSubmitForm(event: any){
    this.onSubmitTransplantRecipientEdit.emit(event);
    window.location.replace('/transplant-recipients/list')

  }

}
