package com.emedicare.userAddressService.configuration;

import com.emedicare.userAddressService.dto.UserAddressDTO;
import com.emedicare.userAddressService.entity.UserAddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
      .createTypeMap(UserAddressDTO.class, UserAddressEntity.class)
      .addMappings(mapper -> mapper.skip(UserAddressEntity::setUserAddressId));
    return modelMapper;
  }
}
