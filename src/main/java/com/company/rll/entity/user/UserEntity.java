package com.company.rll.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_entity")
public class UserEntity {
	
	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	public long user_id;
	
	@Column(name="username")
	public String uname;
	
	@Column(name="password")
	public String pwd;
	
	@Column(name="date_created")
	public String date_created;
	
	public UserEntity() {	}
	
	 public UserEntity(String username, String password, String dateCreated) {
	        this.uname = username;
	        this.pwd = password;
	        this.date_created = dateCreated;
	    }
	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return uname;
	}

	public void setUsername(String username) {
		this.uname = username;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	
	
}

