import { AnalysisRequestService } from '../../services/analysis-request.service';
import { AnalysisRequestFormResult } from '../../model/analysis-request-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';

@Component({
  selector: 'app-analysis-request',
  templateUrl: './analysis-request.component.html',
  styleUrls: ['./analysis-request.component.scss']
})
export class AnalysisRequestComponent {
  mode!: ModeEnum;

  constructor(private analysisRequestService: AnalysisRequestService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitAnalysisRequest(
    analysisRequestFormResult: AnalysisRequestFormResult
  ): void {
    this.analysisRequestService
      .postAnalysisRequest(analysisRequestFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
