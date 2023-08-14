import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import type { User } from '../register/register.component';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private loginurl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  login(user: User): Observable<User> {
    return this.http.put<User>(`${this.loginurl}/user/login`, user);
  }
}
