package com.company.rll.entity.admin;

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
@Entity(name = "admin_location")
@Table(name = "admin_location")
@Data
public class LocationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "location_id")
  private long locationId;

  @Column(nullable = false, length = 255)
  private String terminal;

  @Column(nullable = false, length = 255)
  private String city;

  @Column(nullable = false, length = 255)
  private String province;

  @Column(name = "date_modified", nullable = false)
  private Timestamp dateModified = Timestamp.from(Instant.now());

  @Column(name = "date_created", nullable = false)
  private Timestamp dateCreated = Timestamp.from(Instant.now());
}
