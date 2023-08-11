package com.company.rll.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "user_booking")
@Table(name = "user_booking")
public class BookingEntity {
  @Column(name = "price")
  private long price;

  @Column(name = "seats")
  private long seats;

  @Column(name = "user_id")
  private long user_id;

  @Column(name = "sehedule_id")
  private long sehedule_id;

  @Id
  private long bookingId;
}
