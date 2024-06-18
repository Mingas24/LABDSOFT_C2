import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrganWastageComponent } from './organ-wastage.component';

describe('OrganWastageComponentComponent', () => {
  let component: OrganWastageComponent;
  let fixture: ComponentFixture<OrganWastageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrganWastageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrganWastageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
