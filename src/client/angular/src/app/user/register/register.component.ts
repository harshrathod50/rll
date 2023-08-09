import { Component } from '@angular/core';

import { RegisterService } from './register.service';

export class User {
  user_id!:number; 
  username!:string;
  password!:string ;
  date_created!:string;
 
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
        alert('Successfully User is register');
      },
      (error) => alert('Sorry User not register')
    );
  }

}
// Demo Data={"user_id": 1202,"username": "er","password": "er5","date_created": "08.08.2023"}
