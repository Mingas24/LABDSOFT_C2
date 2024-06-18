import { Observable, tap } from 'rxjs';
import { OrganWastageFormResult } from './../model/organ-wastage-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { REST_API_ORGAN_WASTAGE } from './../../../shared/services/configuration/common-endpoint';

@Injectable({
    providedIn: 'root'
})
export class OrganWastageService{
    private readonly headers: HttpHeaders = new HttpHeaders();
    private readonly backendUrl: string;

    constructor(private httpClient: HttpClient){
        this.backendUrl = environment.backendUrl;
    }

    postOrganWastage(
        organWastageFormResult: OrganWastageFormResult
    ): Observable<Response>{
        return this.httpClient.post<Response>(this.getUrl(), organWastageFormResult, {
            headers: this.getHeaders()
        }).pipe(tap((res) => {}))
    }

    private getUrl(): string {
        return this.backendUrl + REST_API_ORGAN_WASTAGE;
    }

    private getHeaders(): HttpHeaders{
        return new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('access_token')).set('Accept', 'application/json');
    }

}