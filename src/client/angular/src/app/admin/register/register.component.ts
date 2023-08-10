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

  constructor(
    private router: Router,
    private userService: RegisterService
  ) {}

  register(admin: NgForm) {
    this.userService.register(admin.value).subscribe((admin) => {
      this.router.navigate(['/admin/login']);
    });
  }
}
