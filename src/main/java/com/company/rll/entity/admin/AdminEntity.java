package com.company.rll.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AdminEntity {
  @Id
  @Column(name = "admin_id")
  private long adminId;

  private String username;
  private String password;

  @Column(name = "date_created")
  private Date dateCreated;
}
