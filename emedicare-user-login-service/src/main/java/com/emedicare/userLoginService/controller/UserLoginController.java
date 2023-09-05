package com.emedicare.userLoginService.controller;

import com.emedicare.userLoginService.dto.UserDTO;
import com.emedicare.userLoginService.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserLoginController")
@Scope(value = "request")
@RequestMapping(value = "/userLogin")
public class UserLoginController {
  @Autowired
  private UserServiceProxy userServiceProxy;

  @PostMapping(value = "/login")
  public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
    ResponseEntity<Object> response = this.userServiceProxy.login(userDTO);
    return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
  }
}
