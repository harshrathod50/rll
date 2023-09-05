package com.emedicare.userDashboardService.controller;

import com.emedicare.userDashboardService.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserDashboardController")
@Scope(value = "request")
@RequestMapping(value = "/product")
public class UserDashboardController {
  @Autowired
  private ProductServiceProxy productServiceProxy;

  @GetMapping(value = "/readOne/{productId}")
  public ResponseEntity<Object> readOne(@PathVariable("productId") Long productId) {
    ResponseEntity<Object> response = this.productServiceProxy.readOne(productId);
    return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
  }

  @GetMapping(value = "/readMany/{pageNumber}/{itemCount}")
  public ResponseEntity<Object> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    ResponseEntity<Object> response =
      this.productServiceProxy.readMany(pageNumber, itemCount);
    return new ResponseEntity<Object>(response.getBody(), HttpStatus.OK);
  }
}
