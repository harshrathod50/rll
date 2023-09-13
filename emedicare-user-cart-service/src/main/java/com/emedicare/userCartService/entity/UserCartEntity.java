package com.emedicare.userCartService.entity;

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
@Entity(name = "UserCartEntity")
@Table(name = "emedicare_user_cart")
public class UserCartEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userCartId;

  @Column(nullable = false, unique = true)
  private Long userId;

  @OneToMany
  private List<CartItemEntity> items;

  @Column(nullable = false)
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
