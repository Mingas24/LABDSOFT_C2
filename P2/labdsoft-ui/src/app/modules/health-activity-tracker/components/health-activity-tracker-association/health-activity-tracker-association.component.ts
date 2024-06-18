import { HealthActivityTrackerService } from './../../service/health-activity-tracker.service';
import { Component, OnInit } from '@angular/core';
import { ModeEnum } from 'src/app/shared/custom/dynamic-form/enums/mode.enum';
import { HealthActivityTrackerAssociationFormResult } from '../../model/health-activity-tracker-association-form-result.model';

@Component({
  selector: 'app-health-activity-tracker-association',
  templateUrl: './health-activity-tracker-association.component.html',
  styleUrls: ['./health-activity-tracker-association.component.scss']
})
export class HealthActivityTrackerAssociationComponent implements OnInit {
  mode!: ModeEnum;

  constructor(private healthActivityTrackerService: HealthActivityTrackerService) {
    this.mode = ModeEnum.NEW;
   }

  ngOnInit(): void {
  }

  onSubmitHealthActivityTrackerAssociation(
    healthActivityTrackerAssociationFormResult: HealthActivityTrackerAssociationFormResult
  ): void {
    this.healthActivityTrackerService.postHealthActivityTrackerAssociation(healthActivityTrackerAssociationFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }

}
