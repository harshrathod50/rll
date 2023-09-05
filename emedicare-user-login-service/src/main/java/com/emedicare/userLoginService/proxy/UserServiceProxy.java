package com.emedicare.userLoginService.proxy;

import com.emedicare.userLoginService.dto.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "user-register-service")
public interface UserServiceProxy {
  @PostMapping(
    value = "/user/login",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "login", fallbackMethod = "fallbackLogin")
  @Retry(name = "user-register-service")
  public ResponseEntity<Object> login(@RequestBody UserDTO userDTO);

  public default ResponseEntity<Object> fallbackLogin(Long userId, Exception e) {
    try {
      return new ResponseEntity<Object>(
        new UserDTO(null, null, null, null),
        HttpStatus.OK
      );
    } catch (Exception exception) {
      return new ResponseEntity<Object>(
        new UserDTO(null, null, null, null),
        HttpStatus.NOT_FOUND
      );
    }
  }
}
