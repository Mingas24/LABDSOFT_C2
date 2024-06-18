import { Injectable } from "@angular/core";

@Injectable()
export class HealthActivityTrackerAssociationFormAssembler{
    public FORM_SPECIFICATION: any[] = [
        {
            type:'dropdown',
            name:'transplantRecipientIdentification',
            label:'Identificação do Recetor',
            mappingVariable: 'transplantRecipientIdentification',
            required: true,
            options: []
        },
        {
            type: 'text',
            name: 'healthActivityTrackerId',
            label: 'ID do Health Activity Tracker',
            value: '',
            required: true
        }
    ]
}