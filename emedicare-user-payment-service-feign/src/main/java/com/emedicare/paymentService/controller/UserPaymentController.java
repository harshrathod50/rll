package com.emedicare.paymentService.controller;

import com.emedicare.paymentService.dto.CreditCardDTO;
import com.emedicare.paymentService.proxy.PaymentServiceProxy;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope(value = "request")
@RequestMapping(value = "/userFeign/payment")
public class UserPaymentController {
  @Autowired
  private PaymentServiceProxy paymentServiceProxy;

  private static final Logger log = LoggerFactory.getLogger(UserPaymentController.class);

  @PostMapping(
    value = "/creditCard/addOne",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> addCreditcard(@RequestBody CreditCardDTO creditCardDTO) {
    ResponseEntity<Object> response =
      this.paymentServiceProxy.addOneCreditCard(creditCardDTO);
    log.debug("add credit card details");
    return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
  }

  @GetMapping(value = "/creditCard/{id}")
  public ResponseEntity<CreditCardDTO> getCreditCardById(@PathVariable Long id) {
    ResponseEntity<CreditCardDTO> response = paymentServiceProxy.getOneCreditCard(id);
    log.debug("Retrieved credit card details for ID: {}", id);
    return response;
  }

  @GetMapping(value = "/creditCard")
  public ResponseEntity<List<CreditCardDTO>> getAllCreditCards() {
    ResponseEntity<List<CreditCardDTO>> response = paymentServiceProxy.getAllCreditCards();
    log.debug("Retrieved all credit card details.");
    return response;
  }

  @PutMapping(
    value = "/creditCard",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<CreditCardDTO> updateCreditCard(
    @RequestBody CreditCardDTO creditCardDTO
  ) {
    ResponseEntity<CreditCardDTO> response = paymentServiceProxy.updateOneCreditCard(
      creditCardDTO
    );
    log.debug("Updated credit card details for ID: {}", creditCardDTO.getCreditCardId());
    return response;
  }

  @DeleteMapping(value = "/creditCard/{id}")
  public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
    ResponseEntity<Void> response = paymentServiceProxy.deleteOneCreditCard(id);
    log.debug("Deleted credit card with ID: {}", id);
    return response;
  }
}
