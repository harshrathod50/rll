package com.emedicare.userChangePasswordService.controller;

import com.emedicare.userChangePasswordService.dto.UserDTO;
import com.emedicare.userChangePasswordService.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Implementing Spring Cloud Microservices
@RestController(value = "UserChangePasswordController")
@Scope(value = "request")
@RequestMapping(value = "/user")
public class UserChangePasswordController {
  @Autowired
  private UserServiceProxy userServiceProxy;

  @PutMapping(
    value = "/changePassword",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> changePassword(@RequestBody UserDTO userDTO) {
    ResponseEntity<Object> response = this.userServiceProxy.changePassword(userDTO);
    return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
  }
}
