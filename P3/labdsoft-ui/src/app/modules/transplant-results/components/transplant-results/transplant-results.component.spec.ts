import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransplantResultsComponent } from './transplant-results.component';

describe('TransplantResultsComponent', () => {
  let component: TransplantResultsComponent;
  let fixture: ComponentFixture<TransplantResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransplantResultsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransplantResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
