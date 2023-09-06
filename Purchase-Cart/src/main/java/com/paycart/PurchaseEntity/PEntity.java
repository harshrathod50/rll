package com.paycart.PurchaseEntity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PEntity {
  
  @Id
  private Integer pid;
  private double balance;
}
