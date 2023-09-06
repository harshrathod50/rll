package com.example.dto;


public class UserDTO  {

private Long userId;
  private String username;
  private String type;
  private String password;
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public UserDTO() {
	
}
public UserDTO(Long userId, String username, String type, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.type = type;
		this.password = password;
	}
}
