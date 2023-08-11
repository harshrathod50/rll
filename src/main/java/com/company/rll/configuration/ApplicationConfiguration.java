package com.company.rll.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapperBean() {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper;
  }
}
