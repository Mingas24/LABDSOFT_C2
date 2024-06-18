import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantResultsFormComponent } from './transplant-results-form.component';

describe('TransplantResultsFormComponent', () => {
  let component: TransplantResultsFormComponent;
  let fixture: ComponentFixture<TransplantResultsFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantResultsFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantResultsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
