import { SampleRegistrationService } from './../../services/sample-registration.service';
import {  SampleRegistrationFormResult } from './../../model/sample-registration-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';

@Component({
  selector: 'app-sample-registration',
  templateUrl: './sample-registration.component.html',
  styleUrls: ['./sample-registration.component.scss']
})
export class  SampleRegistrationComponent {
  mode!: ModeEnum;

  constructor(private sampleRegistrationService:  SampleRegistrationService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitSampleRegistration(
    sampleRegistrationFormResult:  SampleRegistrationFormResult
  ): void {
    this.sampleRegistrationService
      .postSampleRegistration(sampleRegistrationFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
