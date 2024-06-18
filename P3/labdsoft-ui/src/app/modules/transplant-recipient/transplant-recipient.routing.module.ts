import { TransplantRecipientEditComponent } from './components/transplant-recipient-edit/transplant-recipient-edit.component';
import { TransplantRecipientComponent } from './components/transplant-recipient/transplant-recipient.component';
import { RouterModule, Routes } from "@angular/router";
import { NgModule } from '@angular/core';
import { TransplantRecipientTableComponent } from './components/transplant-recipient-table/transplant-recipient-table.component';

const routes: Routes = [
    { path: '', component: TransplantRecipientComponent },
    { path: 'list', component: TransplantRecipientTableComponent },
    { path: 'edit', component: TransplantRecipientEditComponent}
];

@NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
  })
  export class TransplantRecipientRoutingModule {}