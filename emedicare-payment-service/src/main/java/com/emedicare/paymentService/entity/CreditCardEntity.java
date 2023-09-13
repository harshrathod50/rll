package com.emedicare.paymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "PaymentEntity")
@Table(name = "emedicare_payment")
public class CreditCardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long creditCardId;

  @Column(nullable = false)
  private String nameOnCard;

  @Column(nullable = false)
  private Integer expiryMonth;

  @Column(nullable = false)
  private Integer expiryYear;

  @Column(nullable = false)
  private Short CVV;

  @Column(nullable = false)
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
