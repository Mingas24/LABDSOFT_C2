import { Injectable } from '@angular/core';

@Injectable()
export class AnalysisResultsFormAssembler {
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'dropdown',
            name: 'sampleIdentification',
            label: 'Análise a ser validada',
            value: '',
            mappingVariable: 'sampleIdentifications',
            required: true,
            options: []
        }
    ]
}