import { Component } from '@angular/core';

import { RegisterService } from './register.service';
import { Router } from '@angular/router';

export interface User {
  username: string;
  password: string;
  name: string;
}

@Component({
  selector: 'app-user',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {

  constructor(
    private router: Router,
    private registerService: RegisterService
  ) {}

  userRegister(user: User) {
    this.registerService.registerUser(user).subscribe(
      (user) => {
        this.router.navigate(['/user/login'])
      }
    );
  }
}
