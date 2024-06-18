import { Injectable } from '@angular/core';

@Injectable()
export class SampleRegistrationFormAssembler {
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'dropdown',
            name: 'isRecipient',
            label: 'Dador/Recetor',
            value: '',
            mappingVariable: 'typePatients',
            required: true,
            options: []
        },
        {
            type: 'dropdown',
            name: 'patientIdentification',
            label: 'Paciente',
            value: '',
            mappingVariable: 'patients',
            required: true,
            options: []
        },
        {
            type: 'date',
            name: 'registrationDate',
            label: 'Data de registo',
            value: '',
            required: true
        },
        {
            type: 'text',
            name: 'sampleIdentification',
            label: 'Identificação da amostra',
            value: '',
            required: true
          }
    ]
}