package com.paycart.PurchaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import com.paycart.PurchaseService.PService;

@RestController
@Scope(value="request")
public class PController {
  
  @Autowired
  @Qualifier(value="Purchase-service")
  PService ps;

  //api to purchase a item and then deduct the balance 
  //api to show the current balance of the user
}
