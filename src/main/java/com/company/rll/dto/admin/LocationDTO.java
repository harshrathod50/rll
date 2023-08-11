package com.company.rll.dto.admin;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationDTO implements Serializable {
  private long locationId;
  private String terminal;
  private String city;
  private String province;
}
