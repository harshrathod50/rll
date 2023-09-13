package com.emedicare.userCartService.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "CartItemDTO")
public class CartItemDTO implements Serializable {
  private Long cartItemId;
  private Long userCartId;
  private Long productId;
  private Double quantity;
  private Double price;
}
