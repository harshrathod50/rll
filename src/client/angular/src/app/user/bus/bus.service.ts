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

    
  addBus(){
    //enter adding a bus here
  }   

  //deleteing a bus
  deletebus(bus_id:number):Observable<String>{
    const delete_id={bus_id};
    return this.http.post(`${this.busurl}/deletebus`, delete_id, { responseType: 'text' });
  }


  removeBus(): Observable < Object > { return new Observable() } 
}

