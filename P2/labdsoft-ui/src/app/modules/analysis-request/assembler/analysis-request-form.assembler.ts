import { Injectable } from '@angular/core';

@Injectable()
export class AnalysisRequestFormAssembler {
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
            type: 'readonly',
            name: 'requestedBy',
            label: 'Requerido por',
            value: '',
            required: true
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
            type: 'dropdown',
            name: 'sampleIdentification',
            label: 'Amostra',
            value: '',
            mappingVariable: 'samples',
            required: true,
            options: []
        },
        {
            type: 'checkbox',
            name: 'analysisTypes',
            label: 'Tipos de análises',
            mappingVariable: 'analysisPossibilities',
            required: true,
            options: []
        }
    ]
}