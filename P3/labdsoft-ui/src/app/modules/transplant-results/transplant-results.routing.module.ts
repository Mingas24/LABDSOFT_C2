import { Router, RouterModule, Routes } from '@angular/router';
import { NgModule } from "@angular/core";
import { TransplantResultsTableComponent } from './components/transplant-results-table/transplant-results-table.component';
import { TransplantResultsComponent } from './components/transplant-results/transplant-results.component';

const routes: Routes = [
    { path: '', component: TransplantResultsComponent },
    { path: 'list', component: TransplantResultsTableComponent }
  ];

  @NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
  })
  export class TransplantResultsRoutingModule {}