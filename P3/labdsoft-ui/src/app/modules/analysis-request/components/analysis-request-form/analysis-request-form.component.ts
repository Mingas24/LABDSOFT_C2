import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { AnalysisRequestFormAssembler } from '../../assembler/analysis-request-form.assembler';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { UserService } from 'src/app/shared/services/user.service';
import { SampleRegistrationService } from 'src/app/modules/sample-registration/services/sample-registration.service';
import { AnalysisRequestFormResult } from '../../model/analysis-request-form-result.model';

@Component({
    selector: 'app-analysis-request-form',
    templateUrl: './analysis-request-form.component.html',
    styleUrls: ['./analysis-request-form.component.scss'],
    providers: [AnalysisRequestFormAssembler]
})

export class AnalysisRequestFormComponent implements OnInit {

    @Input() analysisRequest!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitAnalysisRequest = new EventEmitter();
    isLoading: boolean = true;
    private typePatients: Array<string> = ["Recetor", "Dador"];

    constructor(
        private uiLoaderService: UiLoaderService,
        private userService: UserService,
        private sampleService: SampleRegistrationService,
        private analysisRequestFormAssembler: AnalysisRequestFormAssembler
    ) { }

    ngOnInit(): void {
        this.initAnalysisRequestForm();
    }

    initAnalysisRequestForm() {
        this.analysisRequestFormAssembler.FORM_SPECIFICATION.filter(
            (x) => x.name === 'requestedBy'
        )[0].value = this.userService.user.username;

        this.uiLoaderService.getPatientsFormData().subscribe((res) => {
            this.analysisRequestFormAssembler.FORM_SPECIFICATION.filter((x) =>
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
            this.analysisRequestFormAssembler.FORM_SPECIFICATION.filter((x) =>
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
        });
        this.sampleService.getSamples().subscribe((res) => {
            this.analysisRequestFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'sampleIdentification').forEach((x) => {
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
        });
        this.uiLoaderService.getAnalysisRequestFormData().subscribe((res) => {
            this.analysisRequestFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'analysisTypes').forEach((x) => {
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
    }

    onSubmitForm(event: any) {
        let analysisRequestFormResult: AnalysisRequestFormResult = event;
        for (const prop in analysisRequestFormResult) {
            if (prop === 'analysisTypes') {
                let tempArray: string[] = [];
                for (const prop2 in analysisRequestFormResult[prop]) {
                    if ((analysisRequestFormResult[prop] as any)[prop2]) {
                        tempArray.push(prop2);
                    }
                }
                analysisRequestFormResult[prop] = tempArray;
            }
        }
        this.onSubmitAnalysisRequest.emit(analysisRequestFormResult);
        window.location.replace('/transplant-recipients/list')

    }
}
