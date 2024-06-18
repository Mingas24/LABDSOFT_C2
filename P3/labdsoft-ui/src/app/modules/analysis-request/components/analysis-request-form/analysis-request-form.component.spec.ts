import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalysisRequestFormComponent } from './analysis-request-form.component';

describe('AnalysisRequestFormComponent', () => {
  let component: AnalysisRequestFormComponent;
  let fixture: ComponentFixture<AnalysisRequestFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalysisRequestFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalysisRequestFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
