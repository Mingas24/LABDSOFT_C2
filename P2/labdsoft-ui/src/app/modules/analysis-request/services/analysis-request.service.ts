import { Observable, tap } from 'rxjs';
import { AnalysisRequestFormResult } from '../model/analysis-request-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { REST_API_ANALYSIS_REQUEST } from '../../../shared/services/configuration/common-endpoint';

@Injectable({
    providedIn: 'root'
})
export class AnalysisRequestService{
    private readonly headers: HttpHeaders = new HttpHeaders();
    private readonly backendUrl: string;

    constructor(private httpClient: HttpClient){
        this.backendUrl = environment.backendUrl;
    }

    postAnalysisRequest(
        analysisRequestFormResult: AnalysisRequestFormResult
    ): Observable<Response>{
        return this.httpClient.post<Response>(this.getUrl(), analysisRequestFormResult, {
            headers: this.getHeaders()
        }).pipe(tap((res) => {}))
    }

    private getUrl(): string {
        return this.backendUrl + REST_API_ANALYSIS_REQUEST;
    }

    private getHeaders(): HttpHeaders{
        return new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('access_token')).set('Accept', 'application/json');
    }

}