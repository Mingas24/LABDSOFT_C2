import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { SampleRegistrationFormAssembler } from '../../assembler/sample-registration-form.assemble';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';

@Component({
    selector: 'app-sample-registration-form',
    templateUrl: './sample-registration-form.component.html',
    styleUrls: ['./sample-registration-form.component.scss'],
    providers: [SampleRegistrationFormAssembler]
})

export class SampleRegistrationFormComponent implements OnInit {

    @Input() sampleRegistration!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitSampleRegistration = new EventEmitter();
    isLoading: boolean = true;
    private typePatients: Array<string> = ["Recetor", "Dador"];

    constructor(
        private uiLoaderService: UiLoaderService,
        private sampleRegistrationFormAssembler: SampleRegistrationFormAssembler
    ) { }

    ngOnInit(): void {
        this.initSampleRegistrationForm();
    }

    initSampleRegistrationForm() {
        this.uiLoaderService.getPatientsFormData().subscribe((res) => {
            this.sampleRegistrationFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'patientIdentification').forEach((x) => {
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
            this.sampleRegistrationFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'isRecipient').forEach((x) => {
                    if (x.mappingVariable) {
                        x.options = (this.typePatients as any).map(
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
    }

    onSubmitForm(event: any) {
        this.onSubmitSampleRegistration.emit(event);
        window.location.replace('/transplant-recipients/list')

    }
}
