package com.company.rll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = { JacksonAutoConfiguration.class })
public class RllApplication {

  public static void main(String[] args) {
    SpringApplication.run(RllApplication.class, args);
  }
}
