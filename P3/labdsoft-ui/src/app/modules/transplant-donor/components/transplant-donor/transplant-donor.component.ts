import { TransplantDonorFormResult } from './../../model/transplant-donor-form-result.model';
import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { TransplantDonorService } from './../../services/transplant-donor.service';
import { IColumn } from './../../../../shared/custom/dynamic-table/components/data/IGenericService';
import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-transplant-donor',
  templateUrl: './transplant-donor.component.html',
  styleUrls: ['./transplant-donor.component.scss']
})

//TODO -> Implementar US
export class TransplantDonorComponent {
  mode!: ModeEnum;

  //TODO => Falta preencher o construtor. Declarar Serviço
  constructor(private transplantDonorService: TransplantDonorService) {
    this.mode = ModeEnum.NEW
  }

  onSubmitTransplantDonor(
    transplantDonorFormResult: TransplantDonorFormResult
  ): void{
    this.transplantDonorService.postTransplantDonor(transplantDonorFormResult).subscribe((res)=> {
      console.log(res);
    });
  }
}
