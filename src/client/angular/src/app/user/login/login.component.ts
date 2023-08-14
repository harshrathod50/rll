import { Component } from '@angular/core';
import { Router } from '@angular/router';

import type { User } from '../register/register.component';
import { LoginService } from './login.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  onSubmit(user: User) {
    console.log(user);
    this.loginService.login(user).subscribe((user) => {
      if (user != null) {
        this.router.navigate(['/user']); //navigating to user-home page
      } else {
        alert(`OOPS You have missed somewhere with your credentials`);
      }
    });
  }
}
