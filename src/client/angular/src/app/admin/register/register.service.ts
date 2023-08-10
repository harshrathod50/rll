import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from '../adminlogin/adminlogin.component';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  avail: any = null;
  backendUrl = 'http://localhost:8080/admin';

  constructor(private http: HttpClient) {}

  register(admin: Admin) {
    return this.http.post<Admin>(`${this.backendUrl}/register`, admin);
  }
}
