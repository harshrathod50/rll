package com.emedicare.shippingservice.controller;

import com.emedicare.shippingservice.entity.UserEntity;
import com.emedicare.shippingservice.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserController")
@Scope(value = "request")
@RequestMapping(value = "/shipping")
public class UserController {
  @Autowired
  @Qualifier(value = "UserService")
  private UserService userService;

  @PostMapping(
    value = "/add",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public String Shipping(@RequestBody UserEntity userEntity) {
    this.userService.pushtoship(userEntity);
    return "Added";
  }

  @GetMapping(value = "/shippingdetails")
  public List<UserEntity> ShowAlldetails() {
    return this.userService.ShowAlldetails();
  }
}
