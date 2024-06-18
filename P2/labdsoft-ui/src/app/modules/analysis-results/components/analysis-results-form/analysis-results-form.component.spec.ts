import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalysisResultsFormComponent } from './analysis-results-form.component';

describe('AnalysisResultsFormComponent', () => {
  let component: AnalysisResultsFormComponent;
  let fixture: ComponentFixture<AnalysisResultsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalysisResultsFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalysisResultsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
