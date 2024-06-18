import { AdherentService } from './../../services/adherent.service';
import { IColumn } from 'src/app/shared/custom/dynamic-table/components/data/IGenericService';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adherent-table',
  templateUrl: './adherent-table.component.html',
  styleUrls: ['./adherent-table.component.scss']
})
export class AdherentTableComponent {

  columns: IColumn[] = [
    { label: 'Nome Completo', value: 'fullName' },
    { label: 'Idade', value: 'age' },
    { label: 'Nacionaliade', value: 'nationality' },
    { label: 'Emprego', value: 'job' },
    { label: 'Celebridade', value: 'celebrity'}
  ]

  constructor(public service: AdherentService) { }


}
