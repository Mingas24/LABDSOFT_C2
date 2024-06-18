import { AdherentFormAssembler } from './../../assembler/adherent-form.assembler';
import { ModeEnum } from 'src/app/shared/custom/dynamic-form/enums/mode.enum';
import { UiLoaderService } from 'src/app/shared/services/ui-loader.service';
import { UserService } from 'src/app/shared/services/user.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AdherentFormResult } from '../../model/adherent-form-result.model';

@Component({
  selector: 'app-adherent-form',
  templateUrl: './adherent-form.component.html',
  styleUrls: ['./adherent-form.component.scss'],
  providers: [AdherentFormAssembler]
})
export class AdherentFormComponent implements OnInit {

  @Input() adherent!: string;
  @Input() mode!: ModeEnum;
  @Output() onSubmitAdherent = new EventEmitter();
  isLoading: boolean = true;
  private adherentTypes: Array<string> = ["Sim", "Não"];

  constructor(
    private userService: UserService,
    private uiLoaderService: UiLoaderService,
    public adherentFormAssembler: AdherentFormAssembler
  ) { }

  ngOnInit(): void {
    this.initAdherentForm();
  }

  initAdherentForm(){
    this.uiLoaderService.getAdherentFormData().subscribe((res) => {
      this.adherentFormAssembler.FORM_SPECIFICATION.filter(
        (x) => x.type === 'dropdown' || x.type === 'checkbox'
      ).forEach((x) => {
        if(x.mappingVariable) {
          x.options = (this.adherentTypes as any).map(
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

  onSubmitForm(event: any){
    let adherentFormResult: AdherentFormResult = event;
    this.onSubmitAdherent.emit(adherentFormResult);
    window.location.replace('/adherents/list')
  }

}
