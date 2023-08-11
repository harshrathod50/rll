package com.company.rll.controller.user;

import com.company.rll.entity.user.BookingEntity;
import com.company.rll.service.user.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@CrossOrigin
public class BookingController {
  @Autowired
  private BookingService bookingService;

  @GetMapping("/{userId}")
  public BookingEntity getBookingByUserId(@PathVariable long userId) {
    return bookingService.getBookingByUserId(userId);
  }

  @DeleteMapping("/{bookingId}")
  public String deleteBooking(@PathVariable long bookingId) {
    return bookingService.deleteBooking(bookingId);
  }

  @PutMapping("/{bookingId}")
  public BookingEntity updateBooking(
    @PathVariable long bookingId,
    @RequestBody BookingEntity updatedBooking
  ) {
    return bookingService.updateBooking(bookingId, updatedBooking);
  }
  // Add more endpoints as needed

}
