import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { MatButtonModule } from "@angular/material/button";
import { MatButtonToggleModule } from "@angular/material/button-toggle";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatTooltipModule } from "@angular/material/tooltip";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatDialogModule } from "@angular/material/dialog";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
// import {  MatNativeDateModule} from "@angular/material";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
// import {  MatRippleModule} from "@angular/material/r";
import { MatSelectModule } from "@angular/material/select";
import { MatSortModule } from "@angular/material/sort";
import { MatTableModule } from "@angular/material/table";

import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { MatNativeDateModule, MAT_DATE_LOCALE } from "@angular/material/core";

@NgModule({
  declarations: [],
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatPaginatorModule,
    MatTableModule,
    MatDatepickerModule,
    MatButtonModule,
    MatNativeDateModule,
    MatButtonToggleModule,
    MatDialogModule,
    MatCheckboxModule,
    MatSelectModule,
    MatExpansionModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatSortModule,
    MatAutocompleteModule,
    MatIconModule,
    MatTableModule,
  ],
  exports: [
    MatFormFieldModule,
    MatInputModule,
    MatPaginatorModule,
    MatTableModule,
    MatDatepickerModule,
    MatButtonModule,
    MatNativeDateModule,
    MatButtonToggleModule,
    MatDialogModule,
    MatCheckboxModule,
    MatSelectModule,
    MatExpansionModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatSortModule,
    MatAutocompleteModule,
    MatIconModule,
    MatTableModule,
    MatSortModule
  ],
  providers: [
    {
      provide: MAT_DATE_LOCALE,
      useValue: 'pt-PT'
    }
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MaterialModule {}
