package com.company.rll.service.admin;

import com.company.rll.dto.admin.LocationDTO;
import com.company.rll.entity.admin.LocationEntity;
import com.company.rll.repository.admin.LocationRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  @Autowired
  LocationRepository locationRepository;

  @Autowired
  ModelMapper modelMapper;

  public LocationDTO addOne(LocationDTO locationDTO) {
    LocationEntity locationEntity = new LocationEntity();
    this.modelMapper.map(locationDTO, locationEntity);
    locationEntity = this.locationRepository.save(locationEntity);
    this.modelMapper.map(locationEntity, locationDTO);
    return locationDTO;
  }

  public LocationDTO readOne(long locationId) {
    Optional<LocationEntity> locationEntityOptional =
      this.locationRepository.findById(locationId);
    if (locationEntityOptional.isPresent()) {
      LocationDTO locationDTO = new LocationDTO();
      this.modelMapper.map(locationEntityOptional.get(), locationDTO);
      return locationDTO;
    }
    return null;
  }

  public List<LocationDTO> readMultiple(int pageNumber, int count) {
    Page<LocationEntity> locationEntitiesPage =
      this.locationRepository.findAll(PageRequest.of(pageNumber, count));
    List<LocationDTO> locationDTOs = new LinkedList<LocationDTO>();
    locationEntitiesPage
      .stream()
      .forEach(
        locationEntity -> {
          LocationDTO locationDTO = new LocationDTO();
          this.modelMapper.map(locationEntity, locationDTO);
          locationDTOs.add(locationDTO);
        }
      );
    return locationDTOs;
  }

  public LocationDTO updateOne(LocationDTO locationDTO) {
    Optional<LocationEntity> locationEntityOptional =
      this.locationRepository.findById(locationDTO.getLocationId());
    if (locationEntityOptional.isPresent()) {
      this.modelMapper.map(locationDTO, locationEntityOptional.get());
      locationEntityOptional.get().setDateModified(Timestamp.from(Instant.now()));
      this.locationRepository.save(locationEntityOptional.get());
      this.modelMapper.map(locationEntityOptional.get(), locationDTO);
      return locationDTO;
    }
    return null;
  }

  public void removeOne(long locationId) {
    this.locationRepository.deleteById(locationId);
  }

  public Long totalCount() {
    return this.locationRepository.count();
  }
}
