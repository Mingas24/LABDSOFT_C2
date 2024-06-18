import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdherentTableComponent } from './adherent-table.component';

describe('AdherentTableComponent', () => {
  let component: AdherentTableComponent;
  let fixture: ComponentFixture<AdherentTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdherentTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdherentTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
