import { Component } from '@angular/core';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
bookings = [{numSeats:0,userID:0,scheduleID:0,price:0}];
editBooking(booking: any, newValues: any) {
  booking.numSeats = newValues.numSeats;
  booking.userID = newValues.userID;
  booking.scheduleID = newValues.scheduleID;
  booking.price = newValues.price;
}

deleteBooking(index: number) {
  this.bookings.splice(index, 1);
}
}

