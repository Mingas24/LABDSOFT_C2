import { Router, RouterModule, Routes } from '@angular/router';
import { NgModule } from "@angular/core";
import { TransplantDonorTableComponent } from './components/transplant-donor-table/transplant-donor-table.component';
import { TransplantDonorComponent } from './components/transplant-donor/transplant-donor.component';

const routes: Routes = [
    { path: '', component: TransplantDonorComponent },
    { path: 'list', component: TransplantDonorTableComponent }
  ];

  @NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
  })
  export class TransplantDonorRoutingModule {}