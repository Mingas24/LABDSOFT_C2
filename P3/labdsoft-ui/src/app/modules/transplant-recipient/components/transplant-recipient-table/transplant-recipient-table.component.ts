import { TransplantRecipientComponent } from './../transplant-recipient/transplant-recipient.component';
import { TransplantRecipientService } from './../../services/transplant-recipient.service';
import { Component, OnInit } from '@angular/core';
import { IColumn } from 'src/app/shared/custom/dynamic-table/components/data/IGenericService';

@Component({
  selector: 'app-transplant-recipient-table',
  templateUrl: './transplant-recipient-table.component.html',
  styleUrls: ['./transplant-recipient-table.component.scss']
})
export class TransplantRecipientTableComponent {

  columns: IColumn[] = [
    { label:'Data de Registo' , value: 'registrationDate' },
    { label:'Nome Completo' , value: 'fullName' },
    { label:'Data de Nascimento' , value: 'dateOfBirth' },
    { label:'Identificação' , value: 'indentification' },
    { label:'Nacionalidade' , value: 'nationality' },
    { label:'Estado de Urgência' , value: 'stateOfUrgency' },
    { label:'Data de Estado de Urgência' , value: 'stateOfUrgenyDate' },
    { label:'Tipo de Sangue (ABO)' , value: 'bloodType' },
  ]

  constructor(public service: TransplantRecipientService) { }

  ngOnInit(): void {
  }

}
