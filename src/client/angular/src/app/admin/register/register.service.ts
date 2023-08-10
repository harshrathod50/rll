import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from '../adminlogin/adminlogin.component';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  backendUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

  register(admin: Admin): Observable<Admin> {
    return this.http.post<Admin>(`${this.backendUrl}/register`, admin);
  }
}
