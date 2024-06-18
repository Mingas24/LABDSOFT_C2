import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VitalSignsTableComponent } from './vital-signs-table.component';

describe('VitalSignsTableComponent', () => {
  let component: VitalSignsTableComponent;
  let fixture: ComponentFixture<VitalSignsTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VitalSignsTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VitalSignsTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
