package com.emedicare.userPaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CreditCardEntity")
@Table(name = "emedicare_payment_credit_card")
public class CreditCardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long creditCardId;

  @Column(unique = true, nullable = false)
  private String cardNumber;

  @Column(nullable = false)
  private String cardHolderName;

  @Column(nullable = false)
  private Byte expiryMonth;

  @Column(nullable = false)
  private Short expiryYear;

  @Column(nullable = false)
  private Short CVV;
}
