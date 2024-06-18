import { AppointmentService } from './../../services/appointment.service';
import { AppointmentFormResult } from './../../model/appointment-form-result.model';
import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.scss']
})
export class  AppointmentComponent {
  mode!: ModeEnum;

  constructor(private appointmentService:  AppointmentService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitAppointment(
    appointmentFormResult:  AppointmentFormResult
  ): void {
    this.appointmentService
      .postAppointment(appointmentFormResult)
      .subscribe((res) => {
        console.log(res);
      });
      window.location.replace('transplant-recipients/list');
  }

}
