package com.emedicare.paymentService.proxy;

import com.emedicare.paymentService.dto.CreditCardDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.Collections;
import java.util.List;
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

@FeignClient(value = "user-payment-service")
public interface PaymentServiceProxy {
  @PostMapping(
    value = "/user/payment/creditCard/addOne",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(
    name = "/creditCard/addOne",
    fallbackMethod = "fallbackAddOneCreditCard"
  )
  @Retry(name = "user-payment-service")
  ResponseEntity<Object> addOneCreditCard(@RequestBody CreditCardDTO creditCardDTO);

  default ResponseEntity<Object> fallbackAddOneCreditCard(
    CreditCardDTO creditCardDTO,
    Exception e
  ) {
    return new ResponseEntity<Object>(new CreditCardDTO(), HttpStatus.OK);
  }

  @GetMapping(value = "/user/payment/creditCard/{id}")
  @CircuitBreaker(
    name = "/creditCard/getOne",
    fallbackMethod = "fallbackGetOneCreditCard"
  )
  @Retry(name = "user-payment-service")
  ResponseEntity<CreditCardDTO> getOneCreditCard(@PathVariable Long id);

  default ResponseEntity<CreditCardDTO> fallbackGetOneCreditCard(Long id, Exception e) {
    return new ResponseEntity<>(new CreditCardDTO(), HttpStatus.OK);
  }

  @GetMapping(value = "/user/payment/creditCard")
  @CircuitBreaker(
    name = "/creditCard/getAll",
    fallbackMethod = "fallbackGetAllCreditCards"
  )
  @Retry(name = "user-payment-service")
  ResponseEntity<List<CreditCardDTO>> getAllCreditCards();

  default ResponseEntity<List<CreditCardDTO>> fallbackGetAllCreditCards(Exception e) {
    return new ResponseEntity<>(Collections.emptyList(), HttpStatus.SERVICE_UNAVAILABLE);
  }

  @PutMapping(value = "/user/payment/creditCard/{id}")
  @CircuitBreaker(
    name = "/creditCard/update",
    fallbackMethod = "fallbackUpdateOneCreditCard"
  )
  @Retry(name = "user-payment-service")
  ResponseEntity<CreditCardDTO> updateOneCreditCard(
    @RequestBody CreditCardDTO CreditCardDTO
  );

  default ResponseEntity<CreditCardDTO> fallbackUpdateOneCreditCard(
    CreditCardDTO creditCardDTO,
    Exception e
  ) {
    return new ResponseEntity<>(new CreditCardDTO(), HttpStatus.OK);
  }

  @DeleteMapping(value = "/user/payment/creditCard/{id}")
  @CircuitBreaker(
    name = "/creditCard/delete",
    fallbackMethod = "fallbackDeleteOneCreditCard"
  )
  @Retry(name = "user-payment-service")
  ResponseEntity<Void> deleteOneCreditCard(@PathVariable Long id);

  default ResponseEntity<Void> fallbackDeleteOneCreditCard(Long id, Exception e) {
    return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
  }
}
