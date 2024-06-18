import { TransplantResultsService } from './../../services/transplant-results.service';
import { IColumn } from '../../../../shared/custom/dynamic-table/components/data/IGenericService';
import { Component } from '@angular/core';

@Component({
  selector: 'app-transplant-results-table',
  templateUrl: './transplant-results-table.component.html',
  styleUrls: ['./transplant-results-table.component.scss'],

})
export class TransplantResultsTableComponent {

  columns: IColumn[] = [
    {label: 'Nome Completo', value: 'fullName'},
    {label: 'Orgão Transplantado', value: 'transplantedOrgan'},
    {label: 'Data de transplante', value: 'transplantationDate'}
  ]

  constructor(public service: TransplantResultsService) {

   }


}
