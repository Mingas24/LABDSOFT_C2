import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from "@angular/material/icon";
import {MatIconModule} from '@angular/material/icon'




@Component({
  selector: 'app-table-actions',
  templateUrl: './table-actions.component.html',
  styleUrls: ['./table-actions.component.scss']
})

//TODO -> Implementar Actions
export class TableActionsComponent implements OnInit {

  @Input() filterPlaceHolder!: string;
  @Input() disableEditBtn!: boolean;
  @Input() showEditBtn!: boolean;
  @Input() showStatusCb!: boolean;
  @Input() showStatusCbLabel!: string;
  @Input() showAddBtn!: boolean;
  @Input() showAddDonorBtn!: boolean;

  @Output() findByText = new EventEmitter<string>();
  @Output() edit = new EventEmitter<void>();
  @Output() addRecipient = new EventEmitter<void>();
  @Output() addDonor = new EventEmitter<void>();
  @Output() remove = new EventEmitter<void>();
  @Output() showStatus = new EventEmitter<boolean>();
  
  filterValue!: string;
  toggleState: boolean = true;
  showStatusChecked = false;
  
  constructor(private matIconRegistry: MatIconRegistry, sanitizer: DomSanitizer) {
    matIconRegistry.addSvgIcon('cancel-icon', sanitizer.bypassSecurityTrustResourceUrl('assets/cancel-icon.svg'));
    
    matIconRegistry.addSvgIcon('edit-icon', sanitizer.bypassSecurityTrustResourceUrl('assets/edit-icon.svg'));

   }

  ngOnInit(): void {
  }

  clickFindByText(text : string){
    this.findByText.emit();
  }

  clickRemove(){
    this.remove.emit();
  }

  clickShowStatus(checked: boolean){
    this.showStatus.emit(checked);
  }

  clickEdit(){
    this.edit.emit();
  }

  clickAddRecipient(){
    this.addRecipient.emit();
  }

  clickAddDonor(){
    this.addDonor.emit();
  }
}
