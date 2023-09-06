package com.emedicare.userPaymentService.controller;

import com.emedicare.userPaymentService.entity.PaymentCOD;
import com.emedicare.userPaymentService.service.PaymentCODService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "PaymentController")
@Scope(value = "request")
@RequestMapping("/api/paymentCOD")
public class PaymentCODController {
  @Autowired
  private PaymentCODService paymentCODService;

  @PostMapping("/add")
  public ResponseEntity<PaymentCOD> addPayment(@RequestBody PaymentCOD paymentCOD) {
    PaymentCOD newPaymentCOD = paymentCODService.savePayment(paymentCOD);
    return new ResponseEntity<>(newPaymentCOD, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PaymentCOD> getPaymentById(@PathVariable Long id) {
    PaymentCOD paymentCOD = paymentCODService.getPaymentById(id);
    if (paymentCOD != null) {
      return new ResponseEntity<>(paymentCOD, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/all")
  public ResponseEntity<List<PaymentCOD>> getAllPayments() {
    List<PaymentCOD> payments = paymentCODService.getAllPayments();
    return new ResponseEntity<>(payments, HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<PaymentCOD> updatePayment(@RequestBody PaymentCOD paymentCOD) {
    PaymentCOD updatedPaymentCOD = paymentCODService.updatePayment(paymentCOD);
    if (updatedPaymentCOD != null) {
      return new ResponseEntity<>(updatedPaymentCOD, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deletePayment(@PathVariable Long id) {
    paymentCODService.deletePayment(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
