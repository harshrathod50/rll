package com.emedicare.userAddressService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan
@EnableAutoConfiguration
public class UserAddressServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserAddressServiceApplication.class, args);
  }
}
