package com.paycart.PurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.paycart.PurchaseRepository.PRepo;

@Service(value="Purchase-service")
public class PService  {
  
  @Autowired
  @Qualifier(value="Purchase-repo")
  PRepo pr;

  //function subtract the balance when a item is purchased
  //function to show the current balance
}
