import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private loginurl = 'http://localhost:8080/userlogin/login';

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    const data = { username, password };
    console.log(`${username} , pwd:${password}`);
    return this.http.post(this.loginurl, data, { responseType: 'text' });
  }
}
