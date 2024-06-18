import { map, Observable, of, switchMap, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPagedData } from 'src/app/shared/custom/dynamic-table/components/data/IPagedData';
import { VitalSignsDTO } from '../DTO/vitalSignsDTO';
import { REST_API_VITAL_SIGNS_APPOINTMENT, REST_API_VITAL_SIGNS_LIST } from 'src/app/shared/services/configuration/common-endpoint';
import { VitalSignsFormResult } from '../model/vital-signs-form-result.model';

@Injectable({
  providedIn: 'root'
})
export class VitalSignsService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  private getUrl(): string {
    return this.backendUrl ;
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders()
      .set('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
      .set('Accept', 'application/json');
  }

  postVitalsAppointment(
    VitalSignsFormResult: VitalSignsFormResult
): Observable<Response> {
    return this.httpClient.post<Response>
    (this.getUrl() + REST_API_VITAL_SIGNS_APPOINTMENT, VitalSignsFormResult, {
        headers: this.getHeaders()
    }).pipe(tap((res) => { }))
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
  ): Observable<IPagedData<VitalSignsDTO>> {
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
    console.log(this.getUrl() + REST_API_VITAL_SIGNS_LIST);
    return this.httpClient
      .get<IPagedData<VitalSignsDTO>>(
        this.getUrl() + REST_API_VITAL_SIGNS_LIST,
        options
      )
      .pipe(map((userData: IPagedData<VitalSignsDTO>) => userData));
  }
}
