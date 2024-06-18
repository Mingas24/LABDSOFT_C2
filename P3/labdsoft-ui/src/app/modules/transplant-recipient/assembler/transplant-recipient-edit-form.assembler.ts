import { Injectable } from "@angular/core";

@Injectable()
export class TransplantRecipientEditFormAssembler{
    public FORM_SPECIFICATION: any[] = [
        {
            type:'dropdown',
            name:'fullName',
            label:'Nome Completo',
            mappingVariable:'fullName',
            value:'',
            required: true,
            options: []
        },
        {
            type:'dropdown',
            name:'stateOfUrgency',
            label:'Estado de Urgência',
            value:'',
            mappingVariable:'statesOfUrgency',
            required: true,
            options: []
        }
    ];
}