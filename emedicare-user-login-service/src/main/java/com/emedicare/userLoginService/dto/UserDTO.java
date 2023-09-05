package com.emedicare.userLoginService.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "UserDTO")
public class UserDTO implements Serializable {
  private Long userId;
  private String username;
  private String type;
  private String password;
}
