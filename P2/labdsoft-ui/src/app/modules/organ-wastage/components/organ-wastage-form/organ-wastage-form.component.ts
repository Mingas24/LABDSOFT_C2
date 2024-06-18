import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { OrganWastageFormAssembler } from '../../assembler/organ-wastage-form.assembler';
import { TransplantDonorService } from 'src/app/modules/transplant-donor/services/transplant-donor.service';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';

@Component({
    selector: 'app-organ-wastage-form',
    templateUrl: './organ-wastage-form.component.html',
    styleUrls: ['./organ-wastage-form.component.scss'],
    providers: [OrganWastageFormAssembler]
})

export class OrganWastageFormComponent implements OnInit {

    @Input() organWastage!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitOrganWastage = new EventEmitter();
    isLoading: boolean = true;

    constructor(
        private uiLoaderService: UiLoaderService,
        private transplantDonorService: TransplantDonorService,
        private organWastageFormAssembler: OrganWastageFormAssembler
    ) { }

    ngOnInit(): void {
        this.initOrganWastageForm();
    }

    initOrganWastageForm() {
        this.uiLoaderService.getOrganWastageFormData().subscribe((res) => {
            this.organWastageFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'organType').forEach((x) => {
                    if (x.mappingVariable) {
                        x.options = (res.responseObject as any)[x.mappingVariable].map(
                            (x: string) => {
                                return {
                                    key: x,
                                    label: x
                                };
                            }
                        );
                    }
                });
            this.isLoading = false;
        });
        this.transplantDonorService.getTransplantDonors().subscribe((res) => {
            this.organWastageFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'patientIdentification')[0].options
                = (res.responseObject as []).map((x) => {
                    return { key: x['fullName'], label: x['fullName'] };
                });
            this.isLoading = false;
        });
    }

    onSubmitForm(event: any) {
        this.onSubmitOrganWastage.emit(event);
        window.location.replace('/transplant-recipients/list')

    }
}
