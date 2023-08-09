package com.company.rll.entity.admin;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	@Column (name="date_created")
  private Date dateCreated;
	
}
