import { map, Observable, of, switchMap, tap } from 'rxjs';
import { TransplantResultsFormResult } from './../model/transplant-results-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPagedData } from 'src/app/shared/custom/dynamic-table/components/data/IPagedData';
import { filter } from 'lodash';
//import { GenericHttpRequestService } from 'src/app/shared/services/generic-http-request.service';
import {
  REST_API_LIST,
  REST_API_TRANSPLANT_CANDIDATES,
  REST_API_TRANSPLANT_CANDIDATES_LIST,
  REST_API_TRANSPLANT_RESULTS,
  REST_API_TRANSPLANT_RESULTS_ADD,
} from 'src/app/shared/services/configuration/common-endpoint';
import { TransplantResultsDTO } from '../DTO/transplantResultsDTO';
import { Response } from '../../../shared/models/response.model';

@Injectable({
  providedIn: 'root'
})
export class TransplantResultsService {
  // private url = this.configurationService.configuration$.pipe(map((config:ConfigurationRest) => config.serviceRestUrl));
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  addTransplantedOrgan(
    transplantResultsFormResult: TransplantResultsFormResult
  ): Observable<Response>{
    return this.httpClient.post<Response>(
      this.backendUrl + REST_API_TRANSPLANT_RESULTS + REST_API_TRANSPLANT_RESULTS_ADD,
      transplantResultsFormResult,{
        headers: this.getHeaders()
      }
    ).pipe(tap((res) => {}));
  }

  getTransplantCandidates(
    transplantResultsFormResult: TransplantResultsFormResult
  ): Observable<Response> {
    return this.httpClient
      .post<Response>(
        this.getUrl() + REST_API_TRANSPLANT_CANDIDATES_LIST,
        transplantResultsFormResult,
        {
          headers: this.getHeaders()
        }
      )
      .pipe(tap((res) => {}));
  }

  private getUrl(): string {
    return this.backendUrl + REST_API_TRANSPLANT_CANDIDATES;
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
  ): Observable<IPagedData<TransplantResultsDTO>> {
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
      .get<IPagedData<TransplantResultsDTO>>(
        this.backendUrl + REST_API_TRANSPLANT_RESULTS,
        options
      )
      .pipe(map((userData: IPagedData<TransplantResultsDTO>) => userData));
  }
}
