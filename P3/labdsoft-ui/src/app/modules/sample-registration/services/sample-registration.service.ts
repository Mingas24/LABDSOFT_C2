import { Observable, tap } from 'rxjs';
import { SampleRegistrationFormResult } from './../model/sample-registration-form-result.model';
import { environment } from 'src/environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { REST_API_SAMPLE_REGISTRATION } from './../../../shared/services/configuration/common-endpoint';
import { Response } from '../../../shared/models/response.model';

@Injectable({
    providedIn: 'root'
})
export class SampleRegistrationService {
    private readonly headers: HttpHeaders = new HttpHeaders();
    private readonly backendUrl: string;

    constructor(private httpClient: HttpClient) {
        this.backendUrl = environment.backendUrl;
    }

    postSampleRegistration(
        sampleRegistrationFormResult: SampleRegistrationFormResult
    ): Observable<Response> {
        return this.httpClient.post<Response>(this.getUrl(), sampleRegistrationFormResult, {
            headers: this.getHeaders()
        }).pipe(tap((res) => { }))
    }

    getSamples(): Observable<Response> {
        return this.httpClient
            .get<Response>(this.getUrl(), {
                headers: this.getHeaders()
            })
    }

    private getUrl(): string {
        return this.backendUrl + REST_API_SAMPLE_REGISTRATION;
    }

    private getHeaders(): HttpHeaders {
        return new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('access_token')).set('Accept', 'application/json');
    }

}