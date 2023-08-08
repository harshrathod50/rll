import { Component, OnInit } from '@angular/core';
import { RegisterService } from './register.service';

export class User {
  public  email:String | undefined;
  public  password:String | undefined;
  public Choose: String | undefined;
};


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user:User =new User();

  constructor(private registerService: RegisterService) { }

  ngOnInit(): void {
  }

  userRegister(){
    console.log(this.user);
    this.registerService.registerUser(this.user).subscribe(data=>{
    alert("Successfully User is register?")
    },error=>alert("Sorry User not register"));
}
  }
