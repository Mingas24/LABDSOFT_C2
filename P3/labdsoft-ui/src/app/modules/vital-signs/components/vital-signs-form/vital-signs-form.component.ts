import { ModeEnum } from '../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { VitalSignsFormAssembler } from '../../assembler/vital-signs-form.assemble';
import { UserService } from 'src/app/shared/services/user.service';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'app-vital-signs-form',
    templateUrl: './vital-signs-form.component.html',
    styleUrls: ['./vital-signs-form.component.scss'],
    providers: [VitalSignsFormAssembler, DatePipe]
})

export class VitalSignsFormComponent implements OnInit {

    @Input() appointment!: string;
    @Input() mode!: ModeEnum;
    @Output() onSubmitVitalSigns = new EventEmitter();
    isLoading: boolean = true;
    date: Date = new Date();

    constructor(
        private userService: UserService,
        private uiLoaderService: UiLoaderService,
        private vitalSignsFormAssembler: VitalSignsFormAssembler
    ) { }

    ngOnInit(): void {
        this.initVitalSignsAppointmentForm();
    }

    initVitalSignsAppointmentForm() {
        this.vitalSignsFormAssembler.FORM_SPECIFICATION.filter(
            (x) => x.name === 'registeredBy'
          )[0].value = this.userService.user.username;

        this.uiLoaderService.getAppointmentFormData().subscribe((res) => {
            this.vitalSignsFormAssembler.FORM_SPECIFICATION.filter((x) =>
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
        this.onSubmitVitalSigns.emit(event);
    }
}
