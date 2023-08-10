import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BusService } from './bus.service';

export class Bus {
  bus_id!:number;
  location!:string;
  departure!:string;
  eta!:string;
  price!:number;
  availability!:string;

  constructor(bus_id:number,location:string,departure:string,eta:string,price:number,availability:string){
    this.bus_id=bus_id;
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
  currenturl='/user/bus';
  buses!:Bus[];
  constructor(private busService: BusService, private router: Router) {}

  ngOnInit() {
    this.busService.viewAllBus().subscribe((response)=>{this.buses=response;},((error)=>{console.log(error);}));
}
  removeBus(busNo: number) {
    this.busService.deletebus(busNo).subscribe((response)=>{
      if (response === 'Bus Removed') {
        this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {this.router.navigate([this.currenturl]);});
      } else {
        alert(`Could not delete`);
      }
    },(error) => {
      console.error('API Error:', error);
    });
  }
  // updateBus(busNo:Number) {
  //   this.router.navigate(["/updateBus", busNo]);
  // }
}

