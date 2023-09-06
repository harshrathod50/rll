package com.emedicare.userPaymentService.controller;

import com.emedicare.userPaymentService.entity.CreditCardEntity;
import com.emedicare.userPaymentService.service.CreditCardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "CrediCardController")
@Scope(value = "request")
@RequestMapping("/user/payment/creditCard")
public class CreditCardController {
  @Autowired
  private CreditCardService creditCardService;

  @PostMapping("/addOne")
  public ResponseEntity<CreditCardEntity> addOne(
    @RequestBody CreditCardEntity creditCard
  ) {
    return new ResponseEntity<CreditCardEntity>(
      creditCardService.addOne(creditCard),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/readOne/{creditCardId}")
  public ResponseEntity<Object> readOne(@PathVariable("creditCardId") Long creditCardId) {
    CreditCardEntity creditCard = creditCardService.readOne(creditCardId);
    if (creditCard != null) {
      return new ResponseEntity<Object>(creditCard, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/readAll")
  public ResponseEntity<List<CreditCardEntity>> readAll() {
    return new ResponseEntity<List<CreditCardEntity>>(
      creditCardService.readAll(),
      HttpStatus.OK
    );
  }

  @PutMapping("/updateOne")
  public ResponseEntity<Object> updateCreditCard(
    @RequestBody CreditCardEntity creditCard
  ) {
    CreditCardEntity creditCard2 = creditCardService.updateOne(creditCard);
    if (creditCard2 != null) {
      return new ResponseEntity<Object>(creditCard2, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/removeOne/{creaditCardId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteOne(@PathVariable("creaditCardId") Long creditCardId) {
    creditCardService.deleteOne(creditCardId);
  }
}
