import { Observable, tap } from 'rxjs';
import { AnalysisResultsFormResult } from '../models/analysis-results-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { REST_API_ANALYSIS_RESULTS } from '../../../shared/services/configuration/common-endpoint';

@Injectable({
    providedIn: 'root'
})
export class AnalysisResultsService{
    private readonly headers: HttpHeaders = new HttpHeaders();
    private readonly backendUrl: string;

    constructor(private httpClient: HttpClient){
        this.backendUrl = environment.backendUrl;
    }

    postAnalysisResults(
        analysisResultsFormResult: AnalysisResultsFormResult
    ): Observable<Response>{
        let params = new HttpParams();
        let headers = this.getHeaders();
        params = params.append('sampleIdentification', analysisResultsFormResult.sampleIdentification);
        const options = {
            headers: headers,
            params: params
          };
        return this.httpClient.post<Response>(this.getUrl() , null, 
            options
        ).pipe(tap((res) => {}))
    }

    private getUrl(): string {
        return this.backendUrl + REST_API_ANALYSIS_RESULTS;
    }

    private getHeaders(): HttpHeaders{
        return new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('access_token')).set('Accept', 'application/json');
    }

}