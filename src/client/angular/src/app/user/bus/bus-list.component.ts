import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BusService } from './bus.service';

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent {
  bus?:string;
  adminId?:string;
  constructor(private busService: BusService, private router: Router) {}

  ngOnInit() {
    // this.adminId =(string) localStorage.getItem("adminId");
    if (this.adminId == null) {
      this.router.navigate(["/error", "login to continue"]);
    } /*else {
      this.busService.viewAllBus().subscribe(
        (data: null) => {
          this.bus = data;
        },
        (error: any) => {
          this.router.navigate(["/error", "some error occured"]);
        }
      );
    }*/
  }

  removeBus(busNo: any) {
    if (confirm("are you sure you want to delete?")) {
      /*this.busService.removeBus(busNo).subscribe(
        (data: any) => {
          this.busService.viewAllBus().subscribe(
            (data: null) => {
              this.bus = data;
            },
            (error: any) => {
              this.router.navigate(["/error", "some error occured"]);
            }
          );
        },
        (error: any) => {
          this.router.navigate(["/error", "unable to delete"]);
        }
      );*/
    }
  }
  updateBus(busNo:Number) {
    this.router.navigate(["/updateBus", busNo]);
  }
}

