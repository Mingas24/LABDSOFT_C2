import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { TransplantResultsFormResult } from './../../model/transplant-results-form-result.model';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { UserService } from 'src/app/shared/services/user.service';
import { TransplantResultsFormAssembler } from '../../assembler/transplant-results-form.assembler';

@Component({
  selector: 'app-transplant-results-form',
  templateUrl: './transplant-results-form.component.html',
  styleUrls: ['./transplant-results-form.component.scss'],
  providers: [TransplantResultsFormAssembler]
})

export class TransplantResultsFormComponent implements OnInit {

  @Input() transplantResults!: string;
  @Input() mode!: ModeEnum;
  @Output() onSubmitTransplantResults = new EventEmitter();
  isLoading: boolean = true;

  constructor(
    private uiLoaderService: UiLoaderService,
    private transplantResultsFormAssembler: TransplantResultsFormAssembler
  ) { }

  ngOnInit(): void {
    this.initTransplantResultsForm();
  }

  initTransplantResultsForm() {
    this.uiLoaderService.getTransplantedOrganFormData().subscribe((res) => {
      this.transplantResultsFormAssembler.FORM_SPECIFICATION.filter(
        (x) => x.type === 'dropdown' || x.type === 'checkbox'
      ).forEach((x) => {
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
    this.uiLoaderService.getTransplantCandidates().subscribe((res) => {
      this.transplantResultsFormAssembler.FORM_SPECIFICATION.filter(
        (x) => x.type === 'dropdown' && x.name === 'fullName'
      ).forEach((x) => {
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
    this.onSubmitTransplantResults.emit(event);
    window.location.replace('/transplant-results/list')
  }
}
