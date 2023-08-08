import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './register.component';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  baseUrl = 'http://localhost:8074/user';
  constructor(private httpClient: HttpClient) {}

  registerUser(user: User): Observable<Object> {
    console.log(user);
    return this.httpClient.post(`${this.baseUrl}`, user);
  }
}
