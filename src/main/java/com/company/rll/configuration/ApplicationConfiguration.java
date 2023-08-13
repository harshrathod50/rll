package com.company.rll.configuration;

import com.company.rll.dto.admin.LocationDTO;
import com.company.rll.entity.admin.LocationEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapperBean() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
      .createTypeMap(LocationDTO.class, LocationEntity.class)
      .addMappings(mapper -> mapper.skip(LocationEntity::setLocationId));
    return modelMapper;
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
