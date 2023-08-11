package com.company.rll.service.user;

import com.company.rll.entity.user.BookingEntity;
import com.company.rll.repository.user.BookingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
  @Autowired
  private BookingRepository bookingRepository;

  public long createbooking(BookingEntity booking) {
    return bookingRepository.save(booking).getUser_id();
  }

  public List<BookingEntity> showallbookings() {
    return bookingRepository.findAll();
  }

  public BookingEntity getBookingByUserId(long userId) {
    return bookingRepository.findById(userId).orElse(null);
  }

  public String deleteBooking(long bookingId) {
    bookingRepository.deleteById(bookingId);
    return "Booking with ID " + bookingId + " has been deleted.";
  }

  public BookingEntity updateBooking(long bookingId, BookingEntity updatedBooking) {
    BookingEntity booking = bookingRepository.findById(bookingId).orElse(null);
    if (booking != null) {
      booking.setPrice(updatedBooking.getPrice());
      booking.setSeats(updatedBooking.getSeats());
      booking.setSehedule_id(updatedBooking.getSehedule_id());
      return bookingRepository.save(booking);
    }
    return null;
  }
  // Add more methods as needed

}
