import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

import type Location from './location';
import { LocationService } from './location.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css'],
})
export class LocationComponent implements OnInit {
  locations: Location[] = [
    {
      locationId: 0,
      terminal: 'Loading...',
      city: 'Loading...',
      province: 'Loading...',
    },
  ];
  totalCount: Number = 0;
  selected: number = 0;

  constructor(
    private router: Router,
    private locationService: LocationService
  ) {}

  ngOnInit() {
    this.locationService.getLocations(0, 10).subscribe((locations) => {
      this.locations = locations;
    });
    this.locationService.totalCount().subscribe((count) => {
      this.totalCount = count;
    });
    // Reload component on visiting same url again
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.locationService.getLocations(0, 10).subscribe((locations) => {
          this.locations = locations;
        });
      }
    });
  }

  add(location: Location) {
    this.locationService.add(location).subscribe(() => {
      this.ngOnInit();
    });
  }

  update(location: Location) {
    this.locationService.update(location).subscribe((location) => {
      this.ngOnInit();
    });
  }

  remove(locationId: Number) {
    this.locationService.remove(locationId).subscribe(() => {
      this.ngOnInit();
    });
  }

  total() {
    this.locationService.totalCount().subscribe((count) => {
      this.totalCount = count;
    });
  }

  setSelect(index: number) {
    this.selected = index;
  }
}
