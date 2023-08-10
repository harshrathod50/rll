import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bus } from './bus-list.component';

@Injectable({
  providedIn: 'root'
})
export class BusService {
  busurl = 'http://localhost:8080/bus';
 

  constructor(private http: HttpClient) { }
  viewAllBus(): Observable<Bus[]> {
     return this.http.get<Bus[]>(`${this.busurl}/viewAllbuses`);}


  removeBus(): Observable < Object > { return new Observable() } 
}

