import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  backendUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  totalNumberOfBuses() {
    return this.http.get<Number>(`${this.backendUrl}/bus/totalNumberOfBuses`);
  }
  totalNumberOfUsers() {
    return this.http.get<Number>(`${this.backendUrl}/user/totalNumberOfUsers`);
  }
}
