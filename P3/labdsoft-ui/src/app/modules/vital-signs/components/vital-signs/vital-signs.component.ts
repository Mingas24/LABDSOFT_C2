import { VitalSignsFormResult } from '../../model/vital-signs-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';
import { VitalSignsService } from '../../services/vital-signs.service';

@Component({
  selector: 'app-vital-signs',
  templateUrl: './vital-signs.component.html',
  styleUrls: ['./vital-signs.component.scss']
})
export class  VitalSignsComponent {
  mode!: ModeEnum;

  constructor(private vitalSignsService:  VitalSignsService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitVitalSigns(
    vitalSignsFormResult:  VitalSignsFormResult
  ): void {
    this.vitalSignsService
      .postVitalsAppointment(vitalSignsFormResult)
      .subscribe((res) => {
        console.log(res);
      });
      window.location.replace('vital-signs/list');
  }

}
