import { Injectable } from '@angular/core';

@Injectable()
export class VitalSignsFormAssembler {
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'text',
            name: 'vitalsAppointmentDescription',
            label: 'Descrição',
            value: '',
            required: true
        },
        {
            type: 'readonly',
            name: 'registeredBy',
            label: 'Registado por',
            value: ''
        },
        {
            type: 'dropdown',
            name: 'fullName',
            label: 'Paciente',
            value: '',
            mappingVariable: 'fullName',
            required: true,
            options: []
        },
        {
            type: 'text',
            name: 'healthTrackerIdentifier',
            label: 'Identificador Health Tracker',
            value: '',
            required: true
        },
        {
            type: 'text',
            name: 'bloodPressure',
            label: 'Pressão Sangue',
            value: '',
            required: true
        },
        {
            type: 'text',
            name: 'bodyTemperature',
            label: 'Temperatura Corpo',
            value: '',
            required: true
        },
        {
            type: 'text',
            name: 'heartRate',
            label: 'Batimento Cardíaco',
            value: '',
            required: true
        }
    ]
}