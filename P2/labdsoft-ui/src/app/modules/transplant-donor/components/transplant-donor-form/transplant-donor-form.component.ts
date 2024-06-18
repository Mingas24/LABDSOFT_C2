import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { TransplantDonorFormResult } from './../../model/transplant-donor-form-result.model';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { UserService } from 'src/app/shared/services/user.service';
import { TransplantDonorFormAssembler } from '../../assembler/transplant-donor-form.assembler';

@Component({
  selector: 'app-transplant-donor-form',
  templateUrl: './transplant-donor-form.component.html',
  styleUrls: ['./transplant-donor-form.component.scss'],
  providers: [TransplantDonorFormAssembler]
})

//TODO -> Implementar US
export class TransplantDonorFormComponent implements OnInit {

  @Input() transplantDonor!: string;
  @Input() mode!: ModeEnum;
  @Output() onSubmitTransplantDonor = new EventEmitter();
  isLoading: boolean = true;

  constructor(
    private userServie: UserService,
    private uiLoaderService: UiLoaderService,
    private transplantDonorFormAssembler: TransplantDonorFormAssembler
  ) {}

  ngOnInit(): void {
    this.initTransplantDonorForm();
  }

  //TODO -> Acabar Método
  initTransplantDonorForm(){
    this.uiLoaderService.getTransplantDonorFormData().subscribe((res) => {
      this.transplantDonorFormAssembler.FORM_SPECIFICATION.filter(
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
        let transplantDonorFormResult: TransplantDonorFormResult = event;
        for(const prop in transplantDonorFormResult) {
          if(prop === 'organsToDonate' || prop === 'hlaTypes'){
            let tempArray: string[] = [];
            for(const prop2 in transplantDonorFormResult[prop]){
              if((transplantDonorFormResult[prop] as any)[prop2]){
                tempArray.push(prop2);
              }
            }
            transplantDonorFormResult[prop] = tempArray
          }
        }
        this.onSubmitTransplantDonor.emit(transplantDonorFormResult);
        window.location.replace('/transplant-donors/list')
      }
}
