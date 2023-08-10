import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Admin } from '../adminlogin.component';

@Injectable({
  providedIn: 'root',
})
export class AdminServiceService {
  private baseURL = 'http://localhost:8080/admin';

  constructor(private httpClient: HttpClient) {}

  login(admin: Admin): Observable<Admin> {
    return this.httpClient.post<Admin>(`${this.baseURL}/login`, admin);
  }
}
