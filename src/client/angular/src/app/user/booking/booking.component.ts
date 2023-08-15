import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from './booking.service';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  numSeats:number=2;
  bookings: any[] = [
    { numSeats:2, userID: 1, scheduleID: 101, price: 50},
    { numSeats:3, userID: 2, scheduleID: 102, price: 50 },
    // Add more sample bookings as needed
  ];

  editIndex: number | null = null;
  editedBooking: any = {};

  editBooking(index: number) {
    this.editIndex = index;
    // Create a copy of the booking to edit
    this.editedBooking = { ...this.bookings[index] };
    
  }
  
  cancelEdit() {
    this.editIndex = null;
    this.editedBooking = {};
  }
  saveEdit(index: number) {
    // Update the original booking with the edited values
    this.bookings = this.bookings.map((booking, i) => {
      if (i === index) {
        return { ...this.editedBooking };
      } else {
        return booking;
      }
    });
    this.editIndex = null;
    this.editedBooking = {};
  }

  deleteBooking(index: number) {
    // Implement your delete logic here, e.g., remove from API or data source
    this.bookings.splice(index, 1);
  }
}