import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { RegisterService } from './register.service';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  name = 'enjoyer';
  constructor(
    private router: Router,
    private userService: RegisterService
  ) {}

  user(registerUser: NgForm) {
    this.userService.register(registerUser.value).subscribe((data) => {
      if (data.user != null) {
        console.log(data);
        // window.confirm('Registration Successfull');
        alert('Registration Successfull');
        registerUser.reset();
        this.router.navigateByUrl('login');
      } else {
        console.log(data);
        // console.log("NO Output");
        alert('ENTER CORRECT CREDENTAILS');
        registerUser.reset();
      }
    });
  }
}
