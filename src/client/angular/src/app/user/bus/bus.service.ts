import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BusService {

  constructor() { }
  viewAllBus(): Observable < Object > { return new Observable() } 
  removeBus(): Observable < Object > { return new Observable() } 
}

