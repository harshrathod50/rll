import { Component } from '@angular/core';
import { Router } from '@angular/router';

import type { User } from '../register/register.component';
import { LoginService } from './login.service';
import { UserService } from '../user.service';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(
    private userService: UserService,
    private loginService: LoginService,
    private router: Router
  ) {}

  onSubmit(user: User) {
    this.loginService.login(user).subscribe({
      next: (user) => {
        if (user != null) {
          this.userService.isLoggedIn = true;
          this.router.navigate(['/user']);
        }
      },
      error: (err: Error) => {
        alert(err.name + '\n' + err.message);
      },
    });
  }
}
