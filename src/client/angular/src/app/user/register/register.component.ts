import { Component } from '@angular/core';

import { RegisterService } from './register.service';

export class User {
  public name: String | undefined;
  public email: String | undefined;
  public password: String | undefined;
 
}

@Component({
  selector: 'app-user',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  user: User = new User();

  constructor(private registerService: RegisterService) {}

  userRegister() {
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(
      (data) => {
        alert('Successfully User is register?');
      },
      (error) => alert('Sorry User not register')
    );
  }
}
