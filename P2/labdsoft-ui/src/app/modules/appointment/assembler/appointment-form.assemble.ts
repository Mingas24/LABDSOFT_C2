import { Injectable } from '@angular/core';

@Injectable()
export class AppointmentFormAssembler {
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'readonly',
            name: 'registeredBy',
            label: 'Registado por',
            value: ''
        },
        {
            type: 'readonly',
            name: 'registryDate',
            label: 'Registado em',
            value: ''
        },
        {
            type: 'text',
            name: 'appointmentDescription',
            label: 'Descrição',
            value: '',
            required: true
        },
        {
            type: 'dropdown',
            name: 'fullName',
            label: 'Paciente',
            value: '',
            mappingVariable: 'fullName',
            required: true,
            options: []
        }
    ]
}