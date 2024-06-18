import { AnalysisResultsService } from '../../services/analysis-results.service';
import { AnalysisResultsFormResult } from '../../models/analysis-results-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';

@Component({
  selector: 'app-analysis-results',
  templateUrl: './analysis-results.component.html',
  styleUrls: ['./analysis-results.component.scss']
})
export class AnalysisResultsComponent {
  mode!: ModeEnum;

  constructor(private analysisResultsService: AnalysisResultsService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitAnalysisResults(
    analysisResultsFormResult: AnalysisResultsFormResult
  ): void {
    this.analysisResultsService
      .postAnalysisResults(analysisResultsFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
