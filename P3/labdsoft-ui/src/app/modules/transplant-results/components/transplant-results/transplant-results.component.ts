import { TransplantResultsFormResult } from './../../model/transplant-results-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { TransplantResultsService } from './../../services/transplant-results.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-transplant-results',
  templateUrl: './transplant-results.component.html',
  styleUrls: ['./transplant-results.component.scss']
})

export class TransplantResultsComponent {
  mode!: ModeEnum;

  constructor(private transplantResultsService: TransplantResultsService) {
    this.mode = ModeEnum.NEW
  }

  onSubmitTransplantResults(
    transplantResultsFormResult: TransplantResultsFormResult
  ): void{
    this.transplantResultsService.addTransplantedOrgan(transplantResultsFormResult).subscribe((res)=> {
      console.log(res);
    });
  }
}
