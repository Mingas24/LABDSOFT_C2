import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantResultsTableComponent } from './transplant-results-table.component';

describe('TransplantResultsTableComponent', () => {
  let component: TransplantResultsTableComponent;
  let fixture: ComponentFixture<TransplantResultsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantResultsTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantResultsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
