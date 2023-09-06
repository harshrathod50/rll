package com.emedicare.userPaymentService.repository;

import com.emedicare.userPaymentService.entity.PaymentCOD;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "PaymentRepository")
@Scope(value = "singleton")
public interface PaymentCODRepository extends JpaRepository<PaymentCOD, Long> {
  // Additional custom queries (if any) can be added here.

  // For example, if you want to find payments for a specific order:
  // List<PaymentCOD> findByOrderId(Long orderId);
}
