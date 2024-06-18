import { Injectable } from '@angular/core';

@Injectable()
export class TransplantResultsFormAssembler{
    public FORM_SPECIFICATION: any[] = [
          {
            type: 'dropdown',
            name: 'fullName',
            label: 'Candidato',
            value: '',
            mappingVariable: 'candidates',
            required: true,
            options: []
        },
        {
            type: 'text',
            name: 'transplantedOrgan',
            label: 'Orgão Transplantado',
            value: '',
            required: true
        },
        {
            type: 'date',
            name: 'transplantationDate',
            label: 'Data do Transplante',
            value: '',
            required: true
        }
    ]
}