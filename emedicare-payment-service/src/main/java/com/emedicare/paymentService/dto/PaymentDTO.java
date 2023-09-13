package com.emedicare.paymentService.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "PaymentDTO")
public class PaymentDTO implements Serializable {
  private Long paymentId;
  private Long userId;
  private String totalAmount;
  private List<Long> productIds;
}
