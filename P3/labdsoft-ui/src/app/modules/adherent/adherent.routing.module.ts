import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { AdherentComponent } from './components/adherent/adherent.component';

import { AdherentTableComponent } from './components/adherent-table/adherent-table.component';
const routes: Routes = [
    { path: '', component: AdherentComponent },
    { path: 'list', component: AdherentTableComponent }
];

@NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
})
export class AdherentRoutingModule {}