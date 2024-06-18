import { AdherentFormResult } from './../../model/adherent-form-result.model';
import { ModeEnum } from 'src/app/shared/custom/dynamic-form/enums/mode.enum';
import { Component, OnInit } from '@angular/core';
import { AdherentService } from '../../services/adherent.service';

@Component({
  selector: 'app-adherent',
  templateUrl: './adherent.component.html',
  styleUrls: ['./adherent.component.scss']
})
export class AdherentComponent{
  mode!: ModeEnum;

  constructor(private adherentService: AdherentService) { 
    this.mode = ModeEnum.NEW
  }

  onSubmitAdherent(adherentFormResult: AdherentFormResult):void{
    this.adherentService.postAdherent(adherentFormResult).subscribe((res) => {
      console.log(res);
    })
  }

}
