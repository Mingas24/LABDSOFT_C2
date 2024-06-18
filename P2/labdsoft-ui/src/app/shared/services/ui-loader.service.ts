import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Response } from '../models/response.model';
import { REST_API_UI_LOADER, REST_API_ORGAN_WASTAGE_FORM_DATA, REST_API_SAMPLE_REGISTRATION_FORM_DATA, REST_API_ANALYSIS_REQUEST_FORM_DATA, REST_API_APPOINTMENT_REQUEST_FORM_DATA, REST_API_HEALTH_ACTIVITY_TRACKER_ASSOCIATION_FORM_DATA, REST_API_ANALYSIS_RESULTS_FORM_DATA } from './configuration/common-endpoint';


@Injectable({
  providedIn: 'root'
})
export class UiLoaderService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  getTransplantRecipientFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + '/transplant-recipient-form-data',
      {
        headers: this.getHeaders()
      }
    );
  }

  getTransplantRecipientEditFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + '/transplant-recipient-edit-form-data',
      {
        headers: this.getHeaders()
      }
    );
  }

  getTransplantDonorFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + '/transplant-donor-form-data', {
      headers: this.getHeaders()
    }
    )
  }

  getOrganWastageFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_ORGAN_WASTAGE_FORM_DATA, {
      headers: this.getHeaders()
    }
    )
  }

  getPatientsFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_SAMPLE_REGISTRATION_FORM_DATA, {
      headers: this.getHeaders()
    }
    )
  }

  getAnalysisRequestFormData(): Observable<Response> {
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_ANALYSIS_REQUEST_FORM_DATA, {
      headers: this.getHeaders()
    }
    )
  }

  getAppointmentFormData(): Observable<Response>{
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_APPOINTMENT_REQUEST_FORM_DATA, {
        headers: this.getHeaders()
      }
    )
  }

  getHealthActivityTrackerFormData():Observable<Response>{
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_HEALTH_ACTIVITY_TRACKER_ASSOCIATION_FORM_DATA, {
        headers: this.getHeaders()
      }
    )
  }

  getAnalysisResultsFormData():Observable<Response>{
    return this.httpClient.get<Response>(
      this.getUrl() + REST_API_ANALYSIS_RESULTS_FORM_DATA, {
        headers: this.getHeaders()
      }
    )
  }

  private getUrl(): string {
    return this.backendUrl + REST_API_UI_LOADER;
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders()
      .set('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
      .set('Accept', 'application/json');
  }
}
