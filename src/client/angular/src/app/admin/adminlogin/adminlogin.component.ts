import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


export class Admin {
  auname:string=" ";
  apass:string=" ";
  invalid:string = " ";

}

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
 
  auname:string=" ";
  apass:string=" ";
  invalid:string = "";

  constructor(private router: Router) { }

  aLogin = new FormGroup({
    userEmail: new FormControl(''),
    userPassword: new FormControl(''),
  });

  loginAdmin(){
    const formValue = this.aLogin.value;
    this.auname = formValue.userEmail!;
    this.apass = formValue.userPassword!;
    this.authenticate(this.auname, this.apass);
  }

 

  authenticate(username: string, password: string){
    if(username === "Rajalakshmi" && password === "R@jii23"){
      sessionStorage.setItem('adminusername', username);
      this.router.navigate(['/admin/register']);
    }else{
      this.invalid = "Invalid Username or Password";
    }
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('adminusername');
    console.log(!(user === null));
    return !(user === null);
  }


  ngOnInit(): void {
  }

  logout(){
    sessionStorage.removeItem('adminusername');
  }

}
