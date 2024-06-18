import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Response } from '../models/response.model';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;
  user!: User;

  constructor(private httpClient: HttpClient) {
    this.backendUrl = environment.backendUrl;
  }

  getCurrentUser(): Observable<Response> {
    return this.httpClient
      .get<Response>(this.getUrl() + '/get-current-user', {
        headers: this.getHeaders()
      })
      .pipe(tap((res) => (this.user = res.responseObject as User)));
  }

  getUsersByRole(roleDescription: string): Observable<Response> {
    let queryParams = new HttpParams();
    queryParams = queryParams.append('roleDescription', roleDescription);
    return this.httpClient.get<Response>(this.getUrl() + '/get-users-by-role', {
      headers: this.getHeaders(),
      params: queryParams
    });
  }

  getUsers(): Observable<Response> {
    return this.httpClient
      .get<Response>(this.getUrl(), {
        headers: this.getHeaders()
      })
  }

  private getUrl(): string {
    return this.backendUrl + '/user';
  }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders()
      .set('Authorization', 'Bearer ' + localStorage.getItem('access_token'))
      .set('Accept', 'application/json');
  }
}
