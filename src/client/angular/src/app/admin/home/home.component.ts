import { Component, OnInit } from '@angular/core';
import { HomeService } from './home.service';
@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  totalNumberOfBuses: Number;
  totalNumberOfUsers: Number;
  constructor(private homeService: HomeService) {
    this.totalNumberOfBuses = 0;
    this.totalNumberOfUsers = 0;
  }
  ngOnInit(): void {
    this.homeService.totalNumberOfBuses().subscribe((totalNumberOfBuses) => {
      this.totalNumberOfBuses = totalNumberOfBuses;
    });
    this.homeService.totalNumberOfUsers().subscribe((totalNumberOfUsers) => {
      this.totalNumberOfUsers = totalNumberOfUsers;
    });
  
  }
}
