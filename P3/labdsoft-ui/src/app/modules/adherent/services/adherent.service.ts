import { REST_API_ADHERENT, REST_API_ADHERENT_CREATE, REST_API_LIST } from './../../../shared/services/configuration/common-endpoint';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { AdherentDTO } from '../DTO/adherentDTO';
import { IPagedData } from 'src/app/shared/custom/dynamic-table/components/data/IPagedData';
import { map, Observable, of, tap } from 'rxjs';
import { AdherentFormResult } from '../model/adherent-form-result.model';

@Injectable({
  providedIn: "root"
})
export class AdherentService{
    private readonly headers: HttpHeaders = new HttpHeaders();
    private readonly backendUrl: string;

    constructor(private httpClient: HttpClient){
        this.backendUrl = environment.backendUrl;
    }


    postAdherent(
      adherentFormResult: AdherentFormResult
    ): Observable<Response> {
      return this.httpClient
        .post<Response>(
          this.getUrl() + REST_API_ADHERENT_CREATE,
          adherentFormResult,
          {
            headers: this.getHeaders()
          }
        )
        .pipe(tap((res)=> {}));
    }

    private getUrl(): string {
        return this.backendUrl + REST_API_ADHERENT;
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
      ): Observable<IPagedData<AdherentDTO>> {
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
          .get<IPagedData<AdherentDTO>>(
            this.getUrl() + REST_API_LIST,
            options
          )
          .pipe(map((userData: IPagedData<AdherentDTO>) => userData));
      }

    
}