import { Injectable } from '@angular/core';

@Injectable()
export class TransplantRecipientFormAssembler {
  public FORM_SPECIFICATION: any[] = [
    {
      type: 'date',
      name: 'registrationDate',
      label: 'Data de registo',
      value: '',
      required: true
    },
    {
      type: 'readonly',
      name: 'registeredBy',
      label: 'Registado por',
      value: '',
      required: true
    },
    {
      type: 'checkbox',
      name: 'organsInNeed',
      label: 'Orgãos',
      mappingVariable: 'organTypes',
      required: true,
      options: []
    },
    {
      type: 'text',
      name: 'fullName',
      label: 'Nome Completo',
      value: '',
      required: true,
    },
    {
      type: 'text',
      name: 'address',
      label: 'Morada',
      value: '',
      required: true
    },
    {
      type: 'date',
      name: 'dateOfBirth',
      label: 'Data de Nascimento',
      value: '',
      required: true
    },
    {
      type: 'text',
      name: 'identification',
      label: 'Identificação',
      value: '',
      required: true
    },
    {
      type: 'text',
      name: 'nationality',
      label: 'Nacionalidade',
      value: '',
      required: true
    },
    {
      type: 'text',
      name: 'imc',
      label: 'IMC',
      value: '',
      required: true
    },
    {
      type: 'dropdown',
      name: 'assistentDoctor',
      label: 'Médico Assistente',
      value: '',
      required: true,
      options: []
    },
    {
      type: 'dropdown',
      name: 'stateOfUrgency',
      label: 'Estado de Urgência',
      value: '',
      mappingVariable: 'statesOfUrgency',
      required: true,
      options: []
    },
    {
      type: 'date',
      name: 'stateOfUrgencyDate',
      label: 'Data do Estado de Urgência',
      value: '',
      required: true
    },
    {
      type: 'dropdown',
      name: 'bloodType',
      label: 'Tipo de Sangue (ABO)',
      value: '',
      mappingVariable: 'bloodTypes',
      required: true,
      options: []
    },
    {
      type: 'checkbox',
      name: 'hlaTypes',
      label: 'HLA',
      value: '',
      mappingVariable: 'hlaTypes',
      required: true,
      options: []
    }
  ];
}
