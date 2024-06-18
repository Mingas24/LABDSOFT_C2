import { Observable, tap } from 'rxjs';
import { environment } from './../../../../environments/environment';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HealthActivityTrackerAssociationFormResult } from '../model/health-activity-tracker-association-form-result.model';
import { REST_API_HEALTH_ACTIVITY_TRACKER_ASSOCIATION } from 'src/app/shared/services/configuration/common-endpoint';

@Injectable({
  providedIn: 'root'
})
export class HealthActivityTrackerService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
   }

   postHealthActivityTrackerAssociation(
    healthActivityTrackerAssociationFormResult: HealthActivityTrackerAssociationFormResult
   ): Observable<Response>{
    return this.httpClient.post<Response>(this.getUrl(), healthActivityTrackerAssociationFormResult, {
      headers: this.getHeaders()
    }).pipe(tap((res) => {}))
   }


   private getUrl(): string {
    return this.backendUrl + REST_API_HEALTH_ACTIVITY_TRACKER_ASSOCIATION
   }

   private getHeaders(): HttpHeaders{
    return new HttpHeaders().set('Authorization', 'Bearer ' + localStorage.getItem('access_token')).set('Accept', 'application/json');
  }
}
