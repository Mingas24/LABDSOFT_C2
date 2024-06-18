import { AdherentComponent } from './modules/adherent/components/adherent/adherent.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnalysisRequestComponent } from './modules/analysis-request/components/analysis-request/analysis-request.component';
import { AnalysisResultsComponent } from './modules/analysis-results/components/analysis-results/analysis-results.component';
import { HealthActivityTrackerAssociationComponent } from './modules/health-activity-tracker/components/health-activity-tracker-association/health-activity-tracker-association.component';
import { OrganWastageComponent } from './modules/organ-wastage/components/organ-wastage/organ-wastage.component';
import { SampleRegistrationComponent } from './modules/sample-registration/components/sample-registration/sample-registration.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'transplant-recipients',
    loadChildren: () =>
      import('./modules/transplant-recipient/transplant-recipient.module').then(
        (m) => m.TransplantRecipientModule
      )
  },
  {
    path: 'transplant-donors',
    loadChildren: () =>
      import('./modules/transplant-donor/transplant-donor.module').then(
        (m) => m.TransplantDonorModule
      )
  },
  {
    path: 'adherents',
    loadChildren: () =>
      import('./modules/adherent/adherent.module').then(
        (m) => m.AdherentModule
      )
  },
  {
    path: 'transplant-results',
    loadChildren: () =>
      import('./modules/transplant-results/transplant-results.module').then(
        (m) => m.TransplantResultsModule
      )
  },
  {
    path: 'appointments',
    loadChildren: () =>
      import('./modules/appointment/appointment.module').then(
        (m) => m.AppointmentModule
      )
  },
  {
    path: 'organ-wastage',
    component: OrganWastageComponent,
    loadChildren: () =>
      import('./modules/organ-wastage/organ-wastage.module').then(
        (m) => m.OrganWastageModule
      )
  },
  {
    path: 'sample-registration',
    component: SampleRegistrationComponent,
    loadChildren: () =>
      import('./modules/sample-registration/sample-registration.module').then(
        (m) => m.SampleRegistrationModule
      )
  },
  {
    path: 'analysis-request',
    component: AnalysisRequestComponent,
    loadChildren: () =>
      import('./modules/analysis-request/analysis-request.module').then(
        (m) => m.AnalysisRequestModule
      )
  },
  {
    path: 'health-activity-tracker',
    component: HealthActivityTrackerAssociationComponent,
    loadChildren: () =>
      import('./modules/health-activity-tracker/health-activity-tracker.module').then(
        (m) => m.HealthActivityTrackerModule
      )
  },
  {
    path: 'vital-signs',
    loadChildren: () =>
      import('./modules/vital-signs/vital-signs.module').then(
        (m) => m.VitalSignsModule
      )
  },
  {
    path: 'analysis-results',
    component: AnalysisResultsComponent,
    loadChildren: () =>
      import('./modules/analysis-results/analysis-results.module').then(
        (m) => m.AnalysisResultsModule
      )
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
