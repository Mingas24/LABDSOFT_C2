import { map, Observable, of, switchMap, tap } from 'rxjs';
import { TransplantDonorFormResult } from './../model/transplant-donor-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPagedData } from 'src/app/shared/custom/dynamic-table/components/data/IPagedData';
import { filter } from 'lodash';
//import { GenericHttpRequestService } from 'src/app/shared/services/generic-http-request.service';
import {
  REST_API_LIST,
  REST_API_TRANSPLANT_DONOR,
  REST_API_TRANSPLANT_DONOR_CREATE,
  REST_API_TRANSPLANT_DONOR_ORGANS_BY_DONOR
} from 'src/app/shared/services/configuration/common-endpoint';
import { TransplantDonorDTO } from '../DTO/transplantDonorDTO';
import { Response } from '../../../shared/models/response.model';

@Injectable({
  providedIn: 'root'
})
export class TransplantDonorService {
  // private url = this.configurationService.configuration$.pipe(map((config:ConfigurationRest) => config.serviceRestUrl));
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  postTransplantDonor(
    transplantDonorFormResult: TransplantDonorFormResult
  ): Observable<Response> {
    return this.httpClient
      .post<Response>(
        this.getUrl() + REST_API_TRANSPLANT_DONOR_CREATE,
        transplantDonorFormResult,
        {
          headers: this.getHeaders()
        }
      )
      .pipe(tap((res) => {}));
  }

  getTransplantDonors(): Observable<Response> {
    return this.httpClient.get<Response>(this.getUrl(), {
      headers: this.getHeaders()
    });
  }

  getDonatedOrgansByDonor(donorFullName: string): Observable<Response> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append('fullName', donorFullName);
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_TRANSPLANT_DONOR_ORGANS_BY_DONOR,
      {
        headers: this.getHeaders(),
        params: queryParams
      }
    );
  }

  private getUrl(): string {
    return this.backendUrl + REST_API_TRANSPLANT_DONOR;
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders()
      .set('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
      .set('Accept', 'application/json');
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
  ): Observable<IPagedData<TransplantDonorDTO>> {
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
      .get<IPagedData<TransplantDonorDTO>>(
        this.getUrl() + REST_API_LIST,
        options
      )
      .pipe(map((userData: IPagedData<TransplantDonorDTO>) => userData));
  }
}
