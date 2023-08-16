import { Component } from '@angular/core';
import { UserService } from './user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent {

  constructor(private router: Router, private userService: UserService) {}

  logout() {
    this.userService.isLoggedIn = false;
    this.router.navigate(['/']);
  }
}
