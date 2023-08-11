package com.company.rll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.company.rll.entity.admin.BusEntity;
import com.company.rll.repository.admin.BusRepository;
import com.company.rll.service.admin.BusService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BusTests {
  @Mock
  private BusRepository busRepository;

  @InjectMocks
  private BusService busService;

  @Test
  public void testBusEntityConstructor() {
    BusEntity bus = new BusEntity(1, "Location A", "10:00 AM", 1500, "Available");

    assertEquals(1, bus.getBus_id());
    assertEquals("Location A", bus.getLocation());
    assertEquals("10:00 AM", bus.getEta());
    assertEquals(1500, bus.getPrice());
    assertEquals("Available", bus.getAvailability());
  }

  @Test
  public void testFindAllBuses() {
    List<BusEntity> buses = new ArrayList<>();
    buses.add(new BusEntity(1, "Location A", "10:00 AM", 1500, "Available"));
    buses.add(new BusEntity(2, "Location B", "11:00 AM", 1800, "Available"));

    when(busRepository.findAll()).thenReturn(buses);

    List<BusEntity> retrievedBuses = busService.showallbuses();

    assertEquals(2, retrievedBuses.size());
    assertEquals("Location A", retrievedBuses.get(0).getLocation());
    assertEquals("Location B", retrievedBuses.get(1).getLocation());
  }

  @Test
  public void testAddBus() {
    BusEntity busToAdd = new BusEntity(3, "Location C", "12:00 PM", 2000, "Available");

    when(busRepository.save(busToAdd)).thenReturn(busToAdd);

    String result = busService.addbus(busToAdd);

    assertEquals("Bus Added", result);
  }
}
