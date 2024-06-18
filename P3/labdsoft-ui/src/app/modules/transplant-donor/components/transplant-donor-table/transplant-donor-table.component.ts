import { TransplantDonorService } from './../../services/transplant-donor.service';
import { IColumn } from './../../../../shared/custom/dynamic-table/components/data/IGenericService';
import { Component } from '@angular/core';

@Component({
  selector: 'app-transplant-donor-table',
  templateUrl: './transplant-donor-table.component.html',
  styleUrls: ['./transplant-donor-table.component.scss'],

})
export class TransplantDonorTableComponent {

  columns: IColumn[] = [
    { label: 'Nome Completo', value: 'fullName' },
    { label: 'Data do Óbito', value: 'deathDate' },
    { label: 'Data da Colheita', value: 'harvestDate' },
    { label: 'Categoria', value: 'category' },
  ]

  constructor(public service: TransplantDonorService) {

   }


}
