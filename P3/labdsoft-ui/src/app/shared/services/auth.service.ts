import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, Subject, tap } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthRequest } from '../models/auth-request.model';
import { AuthResponse } from '../models/auth-response.model';
import { Response } from '../models/response.model';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly headers: HttpHeaders = new HttpHeaders();
  private readonly backendUrl: string;
  private accessToken: string = '';
  private isLoggedIn = new Subject<boolean>();
  isLoggedInObservable = this.isLoggedIn.asObservable();

  constructor(
    private httpClient: HttpClient,
    private userService: UserService
  ) {
    this.backendUrl = environment.backendUrl;
  }

  checkStatus() {
    if (localStorage.getItem('access_token')) {
      this.isLoggedIn.next(true);
    } else {
      this.isLoggedIn.next(false);
    }
  }

  private setUserAndToken(response: AuthResponse) {
    this.userService.user = response.user!;
    this.token = response?.token!;
    this.isLoggedIn.next(true);
  }

  set token(token: string) {
    this.accessToken = token;
    localStorage.setItem('access_token', token);
  }

  get token(): string {
    if (!this.accessToken) {
      this.accessToken = localStorage.getItem('access_token')!;
    }
    return this.accessToken;
  }

  login(authRequest: AuthRequest): Observable<Response> {
    return this.httpClient
      .post<Response>(this.getUrl() + '/login', authRequest)
      .pipe(
        tap((res) => {
          if (res.success) {
            this.setUserAndToken(res.responseObject as AuthResponse);
          }
        })
      );
  }

  logout(): void {
    localStorage.removeItem('access_token');
  }

  private getUrl(): string {
    return this.backendUrl + '/auth';
  }

  // https://blog.danieleghidoli.it/2020/10/28/load-angular-app-after-user-logged/
}
