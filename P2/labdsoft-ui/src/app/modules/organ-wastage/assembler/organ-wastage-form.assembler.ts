import { Injectable } from '@angular/core';

@Injectable()
export class OrganWastageFormAssembler {
  public FORM_SPECIFICATION: any[] = [
    {
      type: 'dropdown',
      name: 'patientIdentification',
      label: 'Dador',
      value: '',
      required: true,
      options: []
    },
    {
      type: 'dropdown',
      name: 'organType',
      label: 'Tipo de orgão desperdiçado',
      value: '',
      mappingVariable: 'organTypes',
      required: true,
      options: []
    }
  ]
}