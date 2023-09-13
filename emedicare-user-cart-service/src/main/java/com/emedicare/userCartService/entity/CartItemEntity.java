package com.emedicare.userCartService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CartItemEntity")
@Table(name = "emedicare_user_cart_item")
public class CartItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartItemId;

  @ManyToOne
  @JoinColumn(name = "user_cart_id", nullable = false)
  private UserCartEntity userCartEntity;

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
