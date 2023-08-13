import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import type { Observable } from 'rxjs';

import type Location from './location';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  backendURL: String = "http://localhost:8080";

  constructor(private http: HttpClient) {}

  getLocations(pageNumber: Number, count: Number): Observable<Location[]> {
    return this.http.get<Location[]>(`${this.backendURL}/admin/location/read_multiple/${pageNumber}/${count}`);
  }

  add(location: Location): Observable<Location> {
    return this.http.post<Location>(`${this.backendURL}/admin/location/add_one`, location);
  }

  update(location: Location): Observable<Location> {
    return this.http.put<Location>(`${this.backendURL}/admin/location/update_one`, location);
  }

  remove(locationId: Number): Observable<Object> {
    return this.http.delete(`${this.backendURL}/admin/location/remove_one/${locationId}`);
  }

  totalCount(): Observable<Number> {
    return this.http.get<Number>(`${this.backendURL}/admin/location/total_count`);
  }
}
