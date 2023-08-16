import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  isLoggedIn: boolean = false;

  constructor() {}

  get getIsLoggedIn() {
    return this.isLoggedIn;
  }

  set setIsLoggedIn(value: boolean) {
    this.isLoggedIn = value;
  }
}
