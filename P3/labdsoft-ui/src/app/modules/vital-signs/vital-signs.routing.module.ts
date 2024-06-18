import { RouterModule, Routes } from '@angular/router';
import { NgModule } from "@angular/core";
import { VitalSignsTableComponent } from './components/vital-signs-table/vital-signs-table.component';
import { VitalSignsComponent } from './components/vital-signs/vital-signs.component';

const routes: Routes = [
    { path: '', component: VitalSignsComponent },
    { path: 'list', component: VitalSignsTableComponent }
  ];

  @NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
  })
  export class VitalSignsRoutingModule {}