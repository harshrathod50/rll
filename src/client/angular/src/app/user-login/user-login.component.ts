import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserloginService } from './userlogin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {

  constructor(private loginservice: UserloginService , private router: Router) {}

  OnSubmit(form:NgForm){
    if (form.valid) {
      const username = form.value.username;
      const password = form.value.password;
      this.loginservice.login(username, password).subscribe(
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
