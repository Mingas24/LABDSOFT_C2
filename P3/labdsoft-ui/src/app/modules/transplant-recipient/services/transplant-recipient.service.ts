import { REST_API_TRANSPLANT_RECIPIENT_UPDATE_STATUS } from './../../../shared/services/configuration/common-endpoint';
import { TransplantRecipientEditFormResult } from './../models/transplant-recipient-edit-form-result.model';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, of, tap } from 'rxjs';
import { IPagedData } from 'src/app/shared/custom/dynamic-table/components/data/IPagedData';
import { Response } from 'src/app/shared/models/response.model';
import {
  REST_API_LIST,
  REST_API_TRANSPLANT_RECIPIENT
} from 'src/app/shared/services/configuration/common-endpoint';
import { environment } from 'src/environments/environment';
import { TransplantRecipientDTO } from '../DTO/transplantRecipientDTO';
import { TransplantRecipientFormResult } from '../models/transplant-recipient-form-result.model';

@Injectable({
  providedIn: 'root'
})
export class TransplantRecipientService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  postTransplantRecipient(
    transplantRecipientFormResult: TransplantRecipientFormResult
  ): Observable<Response> {
    return this.httpClient
      .post<Response>(this.getUrl(), transplantRecipientFormResult, {
        headers: this.getHeaders()
      })
      .pipe(tap((res) => {}));
  }

  editTransplantRecipientStateOfUrgency(
    transplantRecipientEditFormResult: TransplantRecipientEditFormResult
  ): Observable<Response> {
    return this.httpClient
      .post<Response>(
        this.getUrl() + REST_API_TRANSPLANT_RECIPIENT_UPDATE_STATUS,
        transplantRecipientEditFormResult,
        {
          headers: this.getHeaders()
        }
      )
      .pipe(tap((res) => {}));
  }

  private getUrl(): string {
    return this.backendUrl + REST_API_TRANSPLANT_RECIPIENT;
  }

  private getHeaders(): HttpHeaders {
        return new HttpHeaders()
      .set('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
      .set('Accept', 'application/json')
      .set('Access-Control-Allow-Origin', '*')
      .set('Access-Control-Allow-Methods', 'DELETE, POST, GET, PUT, OPTIONS')
      .set(
        'Access-Control-Allow-Headers',
        'Content-Type, Authorization, X-Requested-With')
  }

  listById(): Observable<IPagedData<any>> {
    return of();
  }

  list(
    pageNumber: number,
    pageSize: number,
    orderBy: string,
    sortOrder: string,
    filterText: string
  ): Observable<IPagedData<TransplantRecipientDTO>> {
    let params = new HttpParams();
    let headers = this.getHeaders();
    params = params.append('pageNumber', pageNumber.toString());
    params = params.append('pageSize', pageSize.toString());
    params = params.append('orderBy', orderBy);
    params = params.append('sortOrder', sortOrder);
    if (filterText) {
      params = params.append('filter', filterText);
    }

    const options = {
      headers,
      params: params
    };

    return this.httpClient
      .get<IPagedData<TransplantRecipientDTO>>(
        this.getUrl() + REST_API_LIST,
        options
      )
      .pipe(map((userData: IPagedData<TransplantRecipientDTO>) => userData));
  }
}
