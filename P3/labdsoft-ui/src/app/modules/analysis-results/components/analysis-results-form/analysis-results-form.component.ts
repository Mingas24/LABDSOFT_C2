import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { AnalysisResultsFormAssembler } from '../../assembler/analysis-results-form.assembler';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';

@Component({
    selector: 'app-analysis-results-form',
    templateUrl: './analysis-results-form.component.html',
    styleUrls: ['./analysis-results-form.component.scss'],
    providers: [AnalysisResultsFormAssembler]
})

export class AnalysisResultsFormComponent implements OnInit {

    @Input() analysisRequest!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitAnalysisResults = new EventEmitter();
    isLoading: boolean = true;

    constructor(
        private uiLoaderService: UiLoaderService,
        private analysisResultsFormAssembler: AnalysisResultsFormAssembler
    ) { }

    ngOnInit(): void {
        this.initAnalysisResultsForm();
    }

    initAnalysisResultsForm() {
        this.uiLoaderService.getAnalysisResultsFormData().subscribe((res) => {
            console.log(res)
            this.analysisResultsFormAssembler.FORM_SPECIFICATION.filter((x) =>
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
                this.isLoading = false;
        });
   
    }

    onSubmitForm(event: any) {
        this.onSubmitAnalysisResults.emit(event);
        window.location.replace('/transplant-recipients/list')
    }
}
