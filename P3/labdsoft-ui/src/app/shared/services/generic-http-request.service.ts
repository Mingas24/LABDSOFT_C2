import { SnackbarService } from './snackbar.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenericHttpRequestService {
  constructor(
    private httpClient: HttpClient,
    private snackbarService: SnackbarService
  ) {}

  public genericPostRequest<T>(
    endpoint: string,
    data: any | null
  ): Observable<T> {
    return this.httpClient.post<T>(endpoint, data);
  }

  public genericPostRequestHandleError<T>(
    endpoint: string,
    data: any | null
  ): Observable<T> {
    return this.httpClient.post<T>(endpoint, data).pipe(
      catchError((e: HttpErrorResponse) => {
        this.snackbarService.showErrorNotification(
          'Ocorreu um erro a aceder à API: ' + e.status + ' ' + e.statusText
        );
        return throwError(() => e);
      })
    );
  }

  public genericPutRequest<T>(
    endpoint: string,
    data: any | null
  ): Observable<T> {
    return this.httpClient.put<T>(endpoint, data);
  }

  public genericPutRequestHandleError<T>(
    endpoint: string,
    data: any | null
  ): Observable<T> {
    return this.httpClient.put<T>(endpoint, data).pipe(
      catchError((e: HttpErrorResponse) => {
        this.snackbarService.showErrorNotification(
          'Ocorreu um erro a aceder à API: ' + e.status + ' ' + e.statusText
        );
        return throwError(() => e);
      })
    );
  }

  public genericGetRequest<T>(
    endpoint: string,
    options?: Object
  ): Observable<T> {
    if (options) {
      return this.httpClient.get<T>(endpoint, options).pipe(
        catchError((e) => {
          this.snackbarService.showErrorNotification(e.message);
          return throwError(e);
        })
      );
    } else {
      return this.httpClient.get<T>(endpoint).pipe(
        catchError((e) => {
          this.snackbarService.showErrorNotification(e.message);
          return throwError(e);
        })
      );
    }
  }

  public genericDeleteRequest<T>(endpoint: string, options?: any) {
    return this.httpClient.delete<T>(endpoint, options);
  }

  public genericDeleteRequestHandleError<T>(
    endpoint: string,
    options?: Object
  ): Observable<T> {
    return this.httpClient.delete<T>(endpoint, options).pipe(
      catchError((e: HttpErrorResponse) => {
        this.snackbarService.showErrorNotification(e.message);
        return throwError(() => e);
      })
    );
  }

  public genericPatchRequestHandleError<T>(
    endpoint: string,
    data: any | null
  ): Observable<T> {
    return this.httpClient.patch<T>(endpoint, data).pipe(
      catchError((e: HttpErrorResponse) => {
        this.snackbarService.showErrorNotification(e.message);
        return throwError(() => e);
      })
    );
  }
}
