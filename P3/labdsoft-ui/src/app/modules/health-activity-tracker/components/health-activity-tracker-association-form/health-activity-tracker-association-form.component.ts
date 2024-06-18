import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { map } from 'rxjs';
import { HealthActivityTrackerAssociationFormAssembler } from './../../assembler/health-activity-tracker-association-form.assembler';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-health-activity-tracker-association-form',
  templateUrl: './health-activity-tracker-association-form.component.html',
  styleUrls: ['./health-activity-tracker-association-form.component.scss'],
  providers: [HealthActivityTrackerAssociationFormAssembler]
})
export class HealthActivityTrackerAssociationFormComponent implements OnInit {
  @Input() mode!: ModeEnum;
  @Output() onSubmitHealthActivityTrackerAssociation = new EventEmitter();
  isLoading: boolean = true;


  constructor(
    private uiLoaderService: UiLoaderService,
    private healthActivityTrackerAssociationFormAssembler:HealthActivityTrackerAssociationFormAssembler
  ) { }

  ngOnInit(): void {
    this.initHealthActivityTrackerAssociationForm();
  }

  initHealthActivityTrackerAssociationForm(){
    this.uiLoaderService.getHealthActivityTrackerFormData().subscribe((res)=> {
      this.healthActivityTrackerAssociationFormAssembler.FORM_SPECIFICATION.filter((x)=> 
      x.name === 'transplantRecipientIdentification').forEach((x) => {
        if(x.mappingVariable) {
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
    })
  }

  onSubmitForm(event: any){
    this.onSubmitHealthActivityTrackerAssociation.emit(event);
    window.location.replace('/transplant-recipients/list')

  }

}
