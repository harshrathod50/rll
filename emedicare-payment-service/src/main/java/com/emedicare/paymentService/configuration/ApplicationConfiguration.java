package com.emedicare.paymentService.configuration;

import com.emedicare.paymentService.dto.ProductDTO;
import com.emedicare.paymentService.entity.PaymentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

  @Bean
  ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper
      .createTypeMap(ProductDTO.class, PaymentEntity.class)
      .addMappings(mapper -> mapper.skip(PaymentEntity::setProductId));
    return modelMapper;
  }
}
