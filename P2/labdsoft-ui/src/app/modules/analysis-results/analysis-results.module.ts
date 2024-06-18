import { AnalysisResultsFormComponent } from './components/analysis-results-form/analysis-results-form.component';
import { AnalysisResultsComponent } from './components/analysis-results/analysis-results.component';
import { DynamicFormModule } from '../../shared/custom/dynamic-form/dynamic-form.module';
import { ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: AnalysisResultsComponent
  }
];

@NgModule({
  declarations: [
    AnalysisResultsComponent,
    AnalysisResultsFormComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    DynamicFormModule,
    RouterModule.forChild(routes)
  ],
  exports: [AnalysisResultsComponent]
})
export class  AnalysisResultsModule { }
