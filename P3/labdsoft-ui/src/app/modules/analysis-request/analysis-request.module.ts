import { AnalysisRequestFormComponent } from './components/analysis-request-form/analysis-request-form.component';
import { AnalysisRequestComponent } from './components/analysis-request/analysis-request.component';
import { DynamicFormModule } from '../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AnalysisRequestComponent
  }
];

@NgModule({
  declarations: [
    AnalysisRequestComponent,
    AnalysisRequestFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    RouterModule.forChild(routes)
  ],
  exports: [AnalysisRequestComponent]
})
export class  AnalysisRequestModule { }
