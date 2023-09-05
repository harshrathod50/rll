package com.emedicare.userDashboardService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UserDashboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserDashboardApplication.class, args);
  }
}
