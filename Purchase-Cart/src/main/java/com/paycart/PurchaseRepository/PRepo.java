package com.paycart.PurchaseRepository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paycart.PurchaseEntity.PEntity;

@Repository(value="Purchase-repo")
@Scope(value = "singleton")
public interface PRepo extends JpaRepository<PEntity ,Integer> {
  
}
