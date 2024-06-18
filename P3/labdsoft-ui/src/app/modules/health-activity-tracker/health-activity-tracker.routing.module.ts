import { NgModule } from '@angular/core';
import { NgModel } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HealthActivityTrackerAssociationComponent } from './components/health-activity-tracker-association/health-activity-tracker-association.component';

const routes: Routes = [
    { path: '', component: HealthActivityTrackerAssociationComponent}
]

@NgModule({
    imports:[
        RouterModule.forChild(routes),
    ],
    exports: [RouterModule]
})
export class HealthActivityTrackerRoutingModule{

}