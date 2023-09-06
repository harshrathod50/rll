package com.emedicare.userAddressService.controller;

import com.emedicare.userAddressService.dto.UserAddressDTO;
import com.emedicare.userAddressService.service.UserAddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "UserAddressController")
@Scope(value = "request")
@RequestMapping(value = "/user/address")
public class UserAddressController {
  @Autowired
  @Qualifier(value = "UserAddressService")
  UserAddressService userAddressService;

  @PostMapping(
    value = "/addOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<UserAddressDTO> addOne(@RequestBody UserAddressDTO userAddress) {
    return new ResponseEntity<UserAddressDTO>(
      this.userAddressService.addOne(userAddress),
      HttpStatus.CREATED
    );
  }

  @GetMapping(
    value = "/readOne/{userAddressId}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readOne(
    @PathVariable("userAddressId") Long userAddressId
  ) {
    UserAddressDTO userAddressDTO = this.userAddressService.readOne(userAddressId);
    if (userAddressDTO != null) {
      return new ResponseEntity<Object>(userAddressDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/readMany/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> readMany(@PathVariable("userId") Long userId) {
    List<UserAddressDTO> userAddressDTOs = this.userAddressService.readMany(userId);
    return new ResponseEntity<Object>(userAddressDTOs, HttpStatus.OK);
  }

  @PutMapping(
    value = "/updateOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> updateOne(@RequestBody UserAddressDTO userAddressDTO) {
    userAddressDTO = this.userAddressService.updateOne(userAddressDTO);
    if (userAddressDTO != null) {
      return new ResponseEntity<Object>(userAddressDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(userAddressDTO, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value = "/removeOne/{userAddressId}")
  @ResponseStatus(HttpStatus.OK)
  public void removeOne(@PathVariable("userAddressId") Long userAddressId) {
    userAddressService.removeOne(userAddressId);
  }
}
