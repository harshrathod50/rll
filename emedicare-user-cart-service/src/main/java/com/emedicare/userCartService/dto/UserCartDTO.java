package com.emedicare.userCartService.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "UserCartDTO")
public class UserCartDTO implements Serializable {
  private Long userCartId;
  private Long userId;
  private List<CartItemDTO> items;
}
