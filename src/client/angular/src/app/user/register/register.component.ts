import { Component } from '@angular/core';

import { RegisterService } from './register.service';
import { Router } from '@angular/router';

export class User {
  username!: string;
  password!: string;
  email!: string;
}

@Component({
  selector: 'app-user',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  user: User = new User();

  constructor(
    private router: Router,
    private registerService: RegisterService
  ) {}

  userRegister() {
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(
      (data) => {
        this.router.navigate(['/user/login'])
      },
      (error) => alert('Sorry User not register')
    );
  }
}
