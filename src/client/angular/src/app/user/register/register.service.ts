import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import type { User } from './register.component';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  baseUrl = 'http://localhost:8080';
  constructor(private httpClient: HttpClient) {}

  registerUser(user: User): Observable<Object> {
    return this.httpClient.post<User>(`${this.baseUrl}/user/register`, user, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    });
  }
}
