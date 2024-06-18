import { VitalSignsService } from '../../services/vital-signs.service';
import { IColumn } from '../../../../shared/custom/dynamic-table/components/data/IGenericService';
import { Component } from '@angular/core';

@Component({
  selector: 'app-vital-signs-table',
  templateUrl: './vital-signs-table.component.html',
  styleUrls: ['./vital-signs-table.component.scss'],

})
export class VitalSignsTableComponent {

  columns: IColumn[] = [
    {label: 'Identificador Health Tracker', value: 'healthTrackerIdentifier'},
    {label: 'Pressão do sangue', value: 'bloodPressure'},
    {label: 'Temperatura corporal', value: 'bodyTemperature'},
    {label: 'Batimento Cardíaco', value: 'heartRate'},
    {label: 'Estado', value: 'stability'}
  ]

  constructor(public service: VitalSignsService) {
   }


}
