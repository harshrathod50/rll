package com.emedicare.userChangePasswordService.proxy;

import com.emedicare.userChangePasswordService.dto.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Implementing Feign, Resilience4j and Retry
@FeignClient(value = "user-register-service")
public interface UserServiceProxy {
  @PutMapping(
    value = "/user/updateOne",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "changePassword", fallbackMethod = "fallbackChangePassword")
  @Retry(name = "user-register-service")
  public ResponseEntity<Object> changePassword(@RequestBody UserDTO userDTO);

  public default ResponseEntity<Object> fallbackChangePassword(Long userId, Exception e) {
    return new ResponseEntity<Object>(new UserDTO(null, null, null, null), HttpStatus.OK);
  }
}
