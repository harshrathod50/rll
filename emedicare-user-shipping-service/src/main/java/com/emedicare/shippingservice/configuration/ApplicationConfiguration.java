package com.emedicare.shippingservice.configuration;

import com.emedicare.shippingservice.dto.UserDTO;
import com.emedicare.shippingservice.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
      .createTypeMap(UserDTO.class, UserEntity.class)
      .addMappings(mapper -> mapper.skip(UserEntity::setShipId));
    return modelMapper;
  }
}
