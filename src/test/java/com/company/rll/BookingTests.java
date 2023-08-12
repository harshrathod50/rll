package com.company.rll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.company.rll.controller.user.BookingController;
import com.company.rll.entity.user.BookingEntity;
import com.company.rll.repository.user.BookingRepository;
import com.company.rll.service.user.BookingService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookingTests {
  @Mock
  private BookingRepository bookingRepository;

  @InjectMocks
  private BookingService bookingService;

  @InjectMocks
  private BookingController bookingController;

  @Test
  public void testCreateBooking() {
    BookingEntity booking = new BookingEntity();
    booking.setUser_id(1L);
    booking.setPrice(100);
    booking.setSeats(2);
    // Set other properties as needed

    when(bookingRepository.save(any(BookingEntity.class))).thenReturn(booking);

    long userId = bookingService.createbooking(booking);

    assertEquals(1L, userId);
  }

  @Test
  public void testGetBookingByUserId() {
    BookingEntity booking = new BookingEntity();
    booking.setUser_id(1L);
    // Set other properties as needed

    when(bookingRepository.findById(1L)).thenReturn(Optional.of(booking));

    BookingEntity retrievedBooking = bookingService.getBookingByUserId(1L);

    assertEquals(1L, retrievedBooking.getUser_id());
  }

  @Test
  public void testDeleteBooking() {
    doNothing().when(bookingRepository).deleteById(1L);

    String result = bookingService.deleteBooking(1L);

    assertEquals("Booking with ID 1 has been deleted.", result);
  }

  @Test
  public void testUpdateBooking() {
    BookingEntity existingBooking = new BookingEntity();
    existingBooking.setBookingId(1L);
    existingBooking.setUser_id(1L);
    existingBooking.setPrice(100);
    existingBooking.setSeats(2);
    // Set other properties as needed

    BookingEntity updatedBooking = new BookingEntity();
    updatedBooking.setPrice(150);
    updatedBooking.setSeats(3);
    // Set other properties as needed

    when(bookingRepository.findById(1L)).thenReturn(Optional.of(existingBooking));
    when(bookingRepository.save(any(BookingEntity.class))).thenReturn(updatedBooking);

    BookingEntity result = bookingService.updateBooking(1L, updatedBooking);

    assertEquals(150, result.getPrice());
    assertEquals(3, result.getSeats());
  }

  @Test
  public void testShowAllBookings() {
    List<BookingEntity> bookings = new ArrayList<>();
    // Add some sample bookings to the list

    when(bookingRepository.findAll()).thenReturn(bookings);

    List<BookingEntity> result = bookingService.showallbookings();

    assertEquals(bookings.size(), result.size());
  }
}
