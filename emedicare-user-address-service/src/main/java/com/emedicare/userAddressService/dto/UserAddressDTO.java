package com.emedicare.userAddressService.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "UserAddressDTO")
public class UserAddressDTO implements Serializable {
  private Long userAddressId;
  private Long userId;
  private String fullName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String pincode;
}
