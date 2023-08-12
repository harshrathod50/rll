import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
    private bookingUrl = 'http://localhost:8080/booking'; // Update with your API URL
  
    constructor(private http: HttpClient) { }
  
    createBooking(scheduleId: number, userId: number, seats: number, price: number): Observable<any> {
      const newBooking: Booking = {
        scheduleId: scheduleId,
        userId: userId,
        seats: seats,
        price: price
      };
  
      return this.http.post(`${this.bookingUrl}/createBooking`, newBooking);
    }
  
    editBooking(bookingId: number, newSeats: number, newPrice: number): Observable<any> {
      const updatedBooking: Booking = {
        id: bookingId,
        seats: newSeats,
        price: newPrice,
        scheduleId: 0,
        userId: 0
      };
  
      return this.http.put(`${this.bookingUrl}/editBooking/${bookingId}`, updatedBooking);
    }
  
    deleteBooking(bookingId: number): Observable<any> {
      return this.http.delete(`${this.bookingUrl}/deleteBooking/${bookingId}`);
    }
  }
  
  // Interface for Booking
  interface Booking {
    id?: number; // Optional since it will be assigned by the server
    scheduleId: number;
    userId: number;
    seats: number;
    price: number;
  }