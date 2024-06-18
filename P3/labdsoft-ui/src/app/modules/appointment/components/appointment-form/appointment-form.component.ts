import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { AppointmentFormAssembler } from '../../assembler/appointment-form.assemble';
import { UserService } from 'src/app/shared/services/user.service';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'app-appointment-form',
    templateUrl: './appointment-form.component.html',
    styleUrls: ['./appointment-form.component.scss'],
    providers: [AppointmentFormAssembler, DatePipe]
})

export class AppointmentFormComponent implements OnInit {

    @Input() appointment!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitAppointment = new EventEmitter();
    isLoading: boolean = true;
    date: Date = new Date();

    constructor(
        private userService: UserService,
        private uiLoaderService: UiLoaderService,
        private appointmentFormAssembler: AppointmentFormAssembler,
        private datePipe: DatePipe
    ) { }

    ngOnInit(): void {
        this.initAppointmentForm();
    }

    initAppointmentForm() {

        this.appointmentFormAssembler.FORM_SPECIFICATION.filter(
            (x) => x.name === 'registeredBy'
          )[0].value = this.userService.user.username;
        
        this.appointmentFormAssembler.FORM_SPECIFICATION.filter(
            (x) => x.name === 'registryDate'
          )[0].value = this.datePipe.transform(this.date, 'dd-MM-yyyy');

        this.uiLoaderService.getAppointmentFormData().subscribe((res) => {
            this.appointmentFormAssembler.FORM_SPECIFICATION.filter((x) =>
                x.name === 'fullName').forEach((x) => {
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
        this.onSubmitAppointment.emit(event);
    }
}
