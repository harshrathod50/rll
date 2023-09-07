package com.emedicare.userManagementService.controller;

import com.emedicare.userManagementService.dto.UserDTO;
import com.emedicare.userManagementService.proxy.UserServiceProxy;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserManagementController")
@Scope(value = "request")
@RequestMapping(value = "/userManagement")
public class UserManagementController {
  @Autowired
  private UserServiceProxy productServiceProxy;

  @GetMapping(value = "/readOne/{productId}")
  public ResponseEntity<Object> readOne(@PathVariable("productId") Long productId) {
    ResponseEntity<Object> response = this.productServiceProxy.readOne(productId);
    return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
  }

  @GetMapping(value = "/readMany/{pageNumber}/{itemCount}")
  public ResponseEntity<ArrayList<UserDTO>> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    ResponseEntity<ArrayList<UserDTO>> response =
      this.productServiceProxy.readMany(pageNumber, itemCount);
    return new ResponseEntity<ArrayList<UserDTO>>(response.getBody(), HttpStatus.OK);
  }

  @DeleteMapping(value = "/removeOne/{userId}")
  public void removeOne(@PathVariable("userId") Long userId) {
    this.productServiceProxy.removeOne(userId);
  }
}
