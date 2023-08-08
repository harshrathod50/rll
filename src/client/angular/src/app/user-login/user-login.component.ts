import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {


  OnSubmit(form:NgForm){
    if (form.valid) {
      const username = form.value.username;
      const password = form.value.password;
      alert(`${username} and ${password}`);
      if(username===' ' && password===' '){alert(`${username} and ${password}`);}
      else {alert(`You have missed something!!!`);}
  }
  }
}
