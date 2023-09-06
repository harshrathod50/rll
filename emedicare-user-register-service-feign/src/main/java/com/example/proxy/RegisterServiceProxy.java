package com.example.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.dto.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@FeignClient(name="user-register-service")
public interface RegisterServiceProxy {


    @PostMapping(value ="/user/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "register-service")
    @CircuitBreaker(name = "register-service", fallbackMethod = "registerFallback")
    ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO);
    
    default ResponseEntity<UserDTO> registerFallback(UserDTO userDTO, Throwable throwable) {
        return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping(value = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "login-service")
    @CircuitBreaker(name = "login-service", fallbackMethod = "loginFallback")
    ResponseEntity<Object> login(@RequestBody UserDTO userDTO);

    default ResponseEntity<Object> loginFallback(UserDTO userDTO, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Login service is currently unavailable.");
    }


    @GetMapping(value = "/user/readOne/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "readOne-service")
    @CircuitBreaker(name = "readOne-service", fallbackMethod = "readOneFallback")
    ResponseEntity<Object> readOne(@PathVariable("userId") Long userId);

    default ResponseEntity<Object> readOneFallback(Long userId, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Unable to fetch user by ID currently.");
    }

    @GetMapping(value = "/user/readOneByUsername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "readByUsername-service")
    @CircuitBreaker(name = "readByUsername-service", fallbackMethod = "readOneByUsernameFallback")
    ResponseEntity<Object> readOneByUsername(@PathVariable("username") String username);

    default ResponseEntity<Object> readOneByUsernameFallback(String username, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Unable to fetch user by username currently.");
    }

    @GetMapping(value = "/user/readMany/{pageNumber}/{itemCount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "readMany-service")
    @CircuitBreaker(name = "readMany-service", fallbackMethod = "readManyFallback")
    ResponseEntity<Object> readMany(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("itemCount") Integer itemCount);

    default ResponseEntity<Object> readManyFallback(Integer pageNumber, Integer itemCount, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Unable to fetch users page currently.");
    }

    @GetMapping(value = "/user/readManyByType/{userType}/{pageNumber}/{itemCount}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "readManyByType-service")
    @CircuitBreaker(name = "readManyByType-service", fallbackMethod = "readManyByTypeFallback")
    ResponseEntity<Object> readManyByType(@PathVariable("userType") String type, @PathVariable("pageNumber") Integer pageNumber, @PathVariable("itemCount") Integer itemCount);

    default ResponseEntity<Object> readManyByTypeFallback(String type, Integer pageNumber, Integer itemCount, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Unable to fetch users of specified type currently.");
    }
    @PutMapping(value = "/user/updateOne", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Retry(name = "update-service")
    @CircuitBreaker(name = "update-service", fallbackMethod = "updateOneFallback")
    ResponseEntity<Object> updateOne(@RequestBody UserDTO userDTO);

    default ResponseEntity<Object> updateOneFallback(UserDTO userDTO, Throwable throwable) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Update service is currently unavailable.");
    }

    @DeleteMapping(value = "/user/removeOne/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @Retry(name = "delete-service")
    @CircuitBreaker(name = "delete-service", fallbackMethod = "removeOneFallback")
    void removeOne(@PathVariable("userId") Long userId);

    default void removeOneFallback(Long userId, Throwable throwable) {
        // You can handle logging or any other action here for fallback. 
        // Since this method's return type is void, no return is required.
    }
	 

}
