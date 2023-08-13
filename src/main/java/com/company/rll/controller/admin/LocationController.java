package com.company.rll.controller.admin;

import com.company.rll.dto.admin.LocationDTO;
import com.company.rll.service.admin.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin/location")
public class LocationController {
  @Autowired
  LocationService locationService;

  @PostMapping("/add_one")
  public ResponseEntity<LocationDTO> addOne(@RequestBody LocationDTO locationDTO) {
    return new ResponseEntity<LocationDTO>(
      locationService.addOne(locationDTO),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/read_one/{locationId}")
  public ResponseEntity<Object> readOne(@PathVariable("locationId") long locationId) {
    LocationDTO locationDTO = this.locationService.readOne(locationId);
    if (locationDTO != null) {
      return new ResponseEntity<Object>(locationDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/read_multiple/{pageNumber}/{count}")
  public ResponseEntity<Object> readMultiple(
    @PathVariable("pageNumber") int pageNumber,
    @PathVariable int count
  ) {
    if (pageNumber >= 0 && count > 0) {
      List<LocationDTO> locationDTOs =
        this.locationService.readMultiple(pageNumber, count);
      return new ResponseEntity<Object>(locationDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @PutMapping("/update_one")
  public ResponseEntity<Object> updateOne(@RequestBody LocationDTO locationDTO) {
    locationDTO = this.locationService.updateOne(locationDTO);
    if (locationDTO != null) {
      return new ResponseEntity<Object>(locationDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(locationDTO, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/remove_one/{locationId}")
  @ResponseStatus(HttpStatus.OK)
  public void removeOne(@PathVariable("locationId") long locationId) {
    locationService.removeOne(locationId);
  }

  @GetMapping("/total_count")
  public ResponseEntity<Long> totalCount() {
    return new ResponseEntity<Long>(locationService.totalCount(), HttpStatus.OK);
  }
}
