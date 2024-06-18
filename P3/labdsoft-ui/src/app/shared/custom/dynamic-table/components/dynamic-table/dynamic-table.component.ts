import { IPagedData } from './../data/IPagedData';
import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { IColumn, IGenericService } from '../data/IGenericService';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort, SortDirection } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { ComponentType } from '@angular/cdk/portal';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  styleUrls: ['./dynamic-table.component.scss']
})
export class DynamicTableComponent implements OnInit {
  //TODO -> Verificar se faltam inputs
  @Input() title!: string;
  @Input() filterPlaceHolder!: string;
  @Input() columns!: IColumn[];
  @Input() columnID!: string;
  @Input() columnIDDetails!: string;
  @Input() service!: IGenericService;
  @Input() showReturnBtn!: boolean;
  @Input() showEditBtn!: boolean;
  @Input() parentId!: string | number;
  @Input() denyRemoval!: string[];
  @Input() showAddBtn!: boolean;
  @Input() showAddDonorBtn!: boolean;
  @Input() showAddTransplantResultBtn!: boolean;
  @Input() showAddAdherentBtn!: boolean;
  @Input() showAddVitalSignsAppointmentBtn!: boolean;

  @ViewChild(MatPaginator, { static: false }) paginator!: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort!: MatSort;

  displayedColumns!: string[];
  pageEvent!: PageEvent;
  filterValue!: string;
  sortOrder!: 'asc';
  sortBy!: string;
  loading = false;
  dataSource: any;
  listData!: IPagedData<any>;

  //TODO -> Verificar construtor
  constructor(public dialog: MatDialog) {}

  ngOnInit(): void {
    this.sortBy = this.columns[0].value;
    this.displayedColumns = this.columns.map((c) => c.value);
    this.loading = true;
    if (this.parentId != null) {
      this.service
        .listById(
          this.parentId,
          0,
          5,
          this.sortBy,
          this.sortOrder,
          this.filterValue
        )
        .subscribe({
          next: (data) => this._firstListResponse(data),
          error: () => (this.loading = false)
        });
    } else {
      this.service
        .list(0, 10, this.sortBy, this.sortOrder, this.filterValue)
        .subscribe({
          next: (data) => this._firstListResponse(data),
          error: () => (this.loading = false)
        });
    }
  }

  refreshTable(goToFirstPage?: boolean) {
    this.loading = true;
    if (this.parentId != null) {
      this.service
        .listById(
          this.parentId,
          this.pageEvent.pageIndex,
          this.pageEvent.pageSize,
          this.sortBy,
          this.sortOrder,
          this.filterValue
        )
        .subscribe({
          next: (data) => this._listResponse(data, goToFirstPage),
          error: () => (this.loading = false)
        });
    } else {
      this.service
        .list(
          this.pageEvent.pageIndex,
          this.pageEvent.pageSize,
          this.sortBy,
          this.sortOrder,
          this.filterValue
        )
        .subscribe({
          next: (data) => this._listResponse(data, goToFirstPage),
          error: () => (this.loading = false)
        });
    }
  }

  getData(text?: string) {
    let goToFirstPage = false;
    if (text != null) {
      //go to the first page after filter changes
      if (this.filterValue != text && this.paginator.pageIndex > 0) {
        goToFirstPage = true;
      }
      this.filterValue = text;
    }
    this.refreshTable(goToFirstPage);
  }

  listResponse(data: IPagedData<any>): void {
    this.listData = data;
    this.dataSource = new MatTableDataSource(this.listData.content);
    this.dataSource.sort = this.sort;
    this.loading = false;
  }

  //TODO -> Método para eliminar

  onPaginateChange(event: PageEvent) {
    const page = event.pageIndex;
    const size = event.pageSize;
    this.getData();
  }

  private _firstListResponse(data: IPagedData<any>) {
    this.listData = data;
    this.pageEvent = {
      pageIndex: 0,
      pageSize: data.size
    } as PageEvent;

    this._listResponse(data);
  }

  private _listResponse(data: IPagedData<any>, goToFirstPage?: boolean) {
    if (goToFirstPage) {
      this.paginator.firstPage();
    }
    this.listData = data;
    this.dataSource = new MatTableDataSource(this.listData.content);
    this.dataSource.sort = this.sort;
    this.loading = false;
  }

  editRecipient() {
    window.location.replace('/transplant-recipients/edit');
  }

  addRecipient() {
    window.location.replace('/transplant-recipients')
  }

  addDonor() {
    window.location.replace('/transplant-donors')
  }

  addTransplantResult(){
    window.location.replace('/transplant-results')
  }

  addAdherent(){
    window.location.replace('/adherents')
  }
  
  addVitalSignsAppointment(){
      window.location.replace('/vital-signs')
  }
}
