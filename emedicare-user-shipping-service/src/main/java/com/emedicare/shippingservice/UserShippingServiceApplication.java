package com.emedicare.shippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan
@EnableAutoConfiguration
public class UserShippingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserShippingServiceApplication.class, args);
  }
}
