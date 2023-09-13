package com.emedicare.userCartService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserCartServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserCartServiceApplication.class, args);
  }
}
