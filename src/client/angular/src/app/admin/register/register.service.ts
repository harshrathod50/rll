import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  avail: any = null;
  backendUrl = 'http://localhost:8080';
  

  constructor(private http: HttpClient) {}
  register(data: any) {
    console.log(data);
    return this.http.post<any>(`${this.backendUrl}/admin/register`, data);
  }
  
  
}
