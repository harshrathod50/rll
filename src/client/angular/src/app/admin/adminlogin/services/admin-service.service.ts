import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Admin } from '../adminlogin.component';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  private baseURL = "http://localhost:4200/admin/login";

  constructor(private httpClient: HttpClient) { }

  signin(cred: Admin): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,cred);
  }
}
