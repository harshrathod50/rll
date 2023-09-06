package com.emedicare.userPaymentService.repository;

import com.emedicare.userPaymentService.entity.CreditCardEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "CreditCardRepository")
@Scope(value = "singleton")
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Long> {
  // Additional custom queries (if any) can be defined here.

  // For example: find a credit card by its number (make sure this query uses encryption or another security measure)
  // Optional<CreditCard> findByCardNumber(String cardNumber);
}
