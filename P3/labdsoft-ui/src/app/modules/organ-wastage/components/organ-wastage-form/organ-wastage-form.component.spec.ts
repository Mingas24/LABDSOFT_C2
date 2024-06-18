import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganWastageFormComponent } from './organ-wastage-form.component';

describe('OrganWastageFormComponent', () => {
  let component: OrganWastageFormComponent;
  let fixture: ComponentFixture<OrganWastageFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganWastageFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrganWastageFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
