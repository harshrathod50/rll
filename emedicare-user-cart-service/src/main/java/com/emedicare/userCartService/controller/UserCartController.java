package com.emedicare.userCartService.controller;

import com.emedicare.userCartService.dto.CartItemDTO;
import com.emedicare.userCartService.dto.UserCartDTO;
import com.emedicare.userCartService.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserCartController")
@Scope(value = "request")
@RequestMapping(value = "/user/cart")
public class UserCartController {
  @Autowired
  @Qualifier(value = "UserCartService")
  UserCartService userCartService;

  @GetMapping(value = "/readCart/{userId}")
  public ResponseEntity<UserCartDTO> readOneByUserId(
    @PathVariable("userId") Long userId
  ) {
    return new ResponseEntity<UserCartDTO>(
      this.userCartService.readOneByUserId(userId),
      HttpStatus.OK
    );
  }

  @PostMapping(value = "/addOneProduct")
  public ResponseEntity<Object> addOneProduct(@RequestBody CartItemDTO cartItemDTO) {
    this.userCartService.addOneProduct(cartItemDTO);
    return new ResponseEntity<Object>(null, HttpStatus.CREATED);
  }
}
