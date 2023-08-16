import { Component } from '@angular/core';
import { AdminService } from './admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent {

  constructor(
    private router: Router,
    private adminService: AdminService) {}

  logout() {
    this.adminService.isLoggedIn = false;
    this.router.navigate(['/']);
  }
}
