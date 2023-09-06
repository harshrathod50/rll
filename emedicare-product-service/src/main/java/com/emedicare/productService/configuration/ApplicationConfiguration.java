package com.emedicare.productService.configuration;

import com.emedicare.productService.dto.ProductDTO;
import com.emedicare.productService.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
      .createTypeMap(ProductDTO.class, ProductEntity.class)
      .addMappings(mapper -> mapper.skip(ProductEntity::setProductId));
    return modelMapper;
  }
}
