import { Observable } from 'rxjs';
import { IPagedData } from './IPagedData';

export interface IGenericService{
    list(pageNumber: number, pageSize: number, orderBy?: string, sortOrder?: string, filterText?: string): Observable<IPagedData<any>>;
    listById(id: string | number, pageNumber: number, pageSize: number, orderBy?: string, sortOrder?: string, filterText?: string): Observable<IPagedData<any>>;
    getElement(id: number | string): Observable<any>;

    //TODO -> método para eliminar
}

export interface IColumn {
    label: string;
    value: string;
    class?: string;
    spanClass?: string;
    openTooltip?: boolean;
    openDetails?:boolean;
    disableHeaderSort?:boolean;
}
