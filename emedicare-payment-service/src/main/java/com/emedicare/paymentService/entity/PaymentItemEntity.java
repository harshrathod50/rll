package com.emedicare.paymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "PaymentItemEntity")
@Table(name = "emedicare_payment_item")
public class PaymentItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymendItemId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paymentId")
  private PaymentEntity paymentEntity;

  @Column(nullable = false)
  private Long productId;

  @Column(nullable = false)
  private Double quantity;

  @Column(nullable = false)
  private Double price;

  @Column(nullable = false)
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
