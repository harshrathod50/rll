package com.emedicare.paymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "PaymentEntity")
@Table(name = "emedicare_payment")
public class PaymentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymendId;

  @Column
  private Long userId;

  @OneToMany
  @Column
  private List<PaymentItemEntity> items;

  @Column(nullable = false)
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
