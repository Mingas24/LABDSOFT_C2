import { BehaviorSubject, iif, Observable, of, Subject, switchMap, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { ConfigurationRest } from './configurationRest';

@Injectable({
    providedIn: 'root'
})

export class ConfigurationService {
    private _configuration$: Subject<ConfigurationRest | undefined> = new BehaviorSubject<ConfigurationRest | undefined>(undefined);

    constructor(private httpClient: HttpClient){

    }

    get configuration$(): Observable<ConfigurationRest>{
        return this._configuration$.pipe(tap(x => console.log(x))).pipe(switchMap(config => iif(()=> undefined === config, this.load(), of(config)))) as Observable<ConfigurationRest>;
    }

    private load(): Observable<ConfigurationRest>{
        const fileConf = './assets/conf/env-conf.json';
        return this.httpClient.get<ConfigurationRest>(fileConf).pipe(tap(conf => this._configuration$.next(conf)));
    }
}