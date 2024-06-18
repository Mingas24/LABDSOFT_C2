import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/components/login.component';
import { NavComponent } from './nav/components/nav.component';

@NgModule({
  declarations: [NavComponent, LoginComponent],
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  exports: [NavComponent, LoginComponent]
})
export class CoreModule {}
