import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  OnSubmit(form: NgForm) {
    if (form.valid) {
      const username = form.value.username;
      const password = form.value.password;
      this.loginService.login(username, password).subscribe(
        (response) => {
          if (response === 'login sucessfull') {
            this.router.navigate(['/userpage']);
          } else {
            alert(`OOPS You have missed somewhere with your credentials`);
          }
        },
        (error) => {
          console.error('API Error:', error);
        }
      );
    }
  }
}
