package com.emedicare.userCartService.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "ApplicationConfiguration")
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
