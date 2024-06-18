import { Injectable } from "@angular/core";

@Injectable()
export class AdherentFormAssembler{
    public FORM_SPECIFICATION: any[] = [
        {
            type: 'text',
            name: 'fullName',
            label: 'Nome Completo',
            value: '',
            required: true
        },
        {
            type: 'text',
            name: 'age',
            label: 'Idade',
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
            name: 'job',
            label: 'Emprego',
            value: '',
            required: true
        },
        {
            type: 'dropdown',
            name: 'celebrity',
            label: 'Celebridade',
            mappingVariable: 'optionsList',
            value: '',
            required: true,
            options: []
        }
    ]
}