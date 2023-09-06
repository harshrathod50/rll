package com.emedicare.productService.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "ProductDTO")
public class ProductDTO implements Serializable {
  private Long productId;
  private String name;
  private String type;
  private String description;
  private Double price;
}
