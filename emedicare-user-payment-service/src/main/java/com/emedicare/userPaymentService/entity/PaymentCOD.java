package com.emedicare.userPaymentService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "PaymentCOD")
@Table(name = "emedicare_payment")
public class PaymentCOD {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id", unique = true, nullable = false)
  private Long orderId;

  @Column(name = "amount", nullable = false)
  private Double amount;

  @Column(name = "payment_status", nullable = false)
  private String paymentStatus; // e.g., Pending, Completed, Failed

  @Column(name = "delivery_date", nullable = true)
  private Date deliveryDate;

  @Column(name = "remarks", nullable = true)
  private String remarks;
}
