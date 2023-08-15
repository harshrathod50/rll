import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { AdminServiceService } from './services/admin-service.service';
import { AdminService } from '../admin.service';

export class Admin {
  //name?: string = undefined;
  name: string = ' ';
  username: string = ' ';
  password: string = ' ';
  
}

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'],
})
export class AdminloginComponent {

  constructor(
    private router: Router,
    private adminService: AdminService,
    private LoginService: AdminServiceService
  ) {}

  login(admin: NgForm) {
    this.LoginService.login(admin.value).subscribe({
      next: (admin) => {
        if (admin != null) {
          this.adminService.isLoggedIn = true;
          this.router.navigate(['/admin']);
        }
      },
      error: (err: Error) => {
        alert(err.name + "\n" + err.message);
      }
    });
  }
}
