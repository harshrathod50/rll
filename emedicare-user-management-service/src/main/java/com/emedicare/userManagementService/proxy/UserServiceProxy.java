package com.emedicare.userManagementService.proxy;

import com.emedicare.userManagementService.dto.UserDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-register-service")
public interface UserServiceProxy {
  @GetMapping(
    value = "/user/readOne/{userId}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "readOne", fallbackMethod = "fallbackReadOne")
  @Retry(name = "user-register-service")
  public ResponseEntity<Object> readOne(@PathVariable("userId") Long userId);

  public default ResponseEntity<Object> fallbackReadOne(Long userId, Exception e) {
    return new ResponseEntity<Object>(new UserDTO(null, null, null, null), HttpStatus.OK);
  }

  @GetMapping(
    value = "/user/readMany/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "readMany", fallbackMethod = "fallbackReadMany")
  @Retry(name = "user-register-service")
  public ResponseEntity<ArrayList<UserDTO>> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  );

  public default ResponseEntity<ArrayList<UserDTO>> fallbackReadMany(
    Integer pageNumber,
    Integer itemCount,
    Exception e
  ) {
    return new ResponseEntity<ArrayList<UserDTO>>(
      new ArrayList<UserDTO>(0),
      HttpStatus.OK
    );
  }

  @DeleteMapping(
    value = "/user/removeOne/{userId}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "removeOne", fallbackMethod = "fallbackRemoveOne")
  @Retry(name = "user-register-service")
  public void removeOne(@PathVariable("userId") Long userId);

  public default void fallbackRemoveOne(Long userId, Exception e) {}
}
