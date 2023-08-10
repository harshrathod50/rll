import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

import { AdminServiceService } from './services/admin-service.service';

export class Admin {
  name?: string = undefined;
  username: string = ' ';
  password: string = ' ';
  invalid: string = ' ';
}

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'],
})
export class AdminloginComponent {

  constructor(
    private router: Router,
    private adminService: AdminServiceService
  ) {}

  login(admin: NgForm) {
    this.adminService.login(admin.value).subscribe((admin) => {
      if (admin != null) {
        this.router.navigate(['/admin']);
      }
    });
  }
}
