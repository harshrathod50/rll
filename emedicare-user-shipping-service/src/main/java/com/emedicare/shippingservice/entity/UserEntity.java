package com.emedicare.shippingservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "UserEntity")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long shipId;

  @JoinColumn(referencedColumnName = "user_id", table = "emedicare_user")
  private Long user_Id;

  @JoinColumn(referencedColumnName = "userAddressId", table = "emedicare_user_address")
  private Long userAddressId;

  @Column(nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
