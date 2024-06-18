import { OrganWastageService } from './../../services/organ-wastage.service';
import { OrganWastageFormResult } from './../../model/organ-wastage-form-result.model';
import { ModeEnum } from './../../../../shared/custom/dynamic-form/enums/mode.enum';
import { Component } from '@angular/core';

@Component({
  selector: 'app-organ-wastage',
  templateUrl: './organ-wastage.component.html',
  styleUrls: ['./organ-wastage.component.scss']
})
export class OrganWastageComponent {
  mode!: ModeEnum;

  constructor(private organWastageService: OrganWastageService) {
    this.mode = ModeEnum.NEW;
  }

  onSubmitOrganWastage(
    organWastageFormResult: OrganWastageFormResult
  ): void {
    this.organWastageService
      .postOrganWastage(organWastageFormResult)
      .subscribe((res) => {
        console.log(res);
      });
  }
}
