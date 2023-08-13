package com.company.rll.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "user")
@Table(name = "user")
@Data
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long userId;

  private String name;

  @Column(unique = true)
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "date_modified")
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(name = "date_created")
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
