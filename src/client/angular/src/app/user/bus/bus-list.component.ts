import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusService } from './bus.service';

export class Bus {
  location!:string;
  departure!:string;
  eta!:string;
  price!:number;
  availability!:string;

  constructor(location:string,departure:string,eta:string,price:number,availability:string){
    this.location=location;
    this.departure=departure;
    this.eta=eta;
    this.price=price;
    this.availability=availability;
  }
}

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit {

  buses!:Bus[];
  bus?:string;
  constructor(private busService: BusService, private router: Router) {}

  ngOnInit() {
    this.busService.viewAllBus().subscribe((response)=>{this.buses=response;},((error)=>{console.log(error);}));
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

