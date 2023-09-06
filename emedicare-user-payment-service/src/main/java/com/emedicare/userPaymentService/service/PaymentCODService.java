package com.emedicare.userPaymentService.service;

import com.emedicare.userPaymentService.entity.PaymentCOD;
import com.emedicare.userPaymentService.repository.PaymentCODRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class PaymentCODService {
  @Autowired
  @Qualifier(value = "PaymentRepository")
  private PaymentCODRepository paymentCODRepository;

  // Save a new PaymentCOD
  public PaymentCOD savePayment(PaymentCOD paymentCOD) {
    return paymentCODRepository.save(paymentCOD);
  }

  // Get a specific PaymentCOD by ID
  public PaymentCOD getPaymentById(Long id) {
    Optional<PaymentCOD> paymentCODOptional = paymentCODRepository.findById(id);
    return paymentCODOptional.orElse(null);
  }

  // Get all PaymentCODs
  public List<PaymentCOD> getAllPayments() {
    return paymentCODRepository.findAll();
  }

  // Update an existing PaymentCOD
  public PaymentCOD updatePayment(PaymentCOD paymentCOD) {
    if (paymentCODRepository.existsById(paymentCOD.getId())) {
      return paymentCODRepository.save(paymentCOD);
    }
    return null; // or throw an appropriate exception
  }

  // Delete a PaymentCOD by ID
  public void deletePayment(Long id) {
    if (paymentCODRepository.existsById(id)) {
      paymentCODRepository.deleteById(id);
    }
    // else, you can either do nothing or throw an appropriate exception
  }
}
