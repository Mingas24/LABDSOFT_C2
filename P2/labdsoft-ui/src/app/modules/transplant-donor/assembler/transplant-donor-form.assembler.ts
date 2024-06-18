import { Injectable } from '@angular/core';

@Injectable()
export class TransplantDonorFormAssembler{
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'text',
            name: 'fullName',
            label: 'Nome Completo',
            value: '',
            required: true
          },
        {
            type: 'date',
            name: 'deathDate',
            label: 'Data do óbito',
            value: '',
            required: true
        },
        {
            type: 'date',
            name: 'harvestDate',
            label: 'Data da colheita',
            value: '',
            required: true
        },
        {
            type: 'checkbox',
            name: 'organsToDonate',
            label: 'Orgãos',
            mappingVariable: 'organTypes',
            required: true,
            options: []
        },
        {
            type: 'text',
            name: 'category',
            label: 'Categoria',
            value: '',
            mappingVariable: 'category',
            required: true,
            options: []
          },
          {
            type: 'text',
            name: 'viralAnalysis',
            label: 'Análises Víricas',
            value: '',
            required: true
          },
          {
            type: 'checkbox',
            name: 'hlaTypes',
            label: 'HLA',
            value: '',
            mappingVariable: 'hlaTypes',
            required: true,
            options: []
          },
          {
            type: 'dropdown',
            name: 'bloodType',
            label: 'Tipo de Sangue (ABO)',
            value: '',
            mappingVariable: 'bloodTypes',
            required: true,
            options: []
          }
    ]
}