package com.emedicare.userRegisterService.controller;

import com.emedicare.userRegisterService.dto.UserDTO;
import com.emedicare.userRegisterService.service.UserService;
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

@RestController(value = "UserController")
@Scope(value = "request")
@RequestMapping(value = "/user")
public class UserController {
  @Autowired
  @Qualifier(value = "UserService")
  private UserService userService;

  @PostMapping(
    value = "/register",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
    return new ResponseEntity<UserDTO>(
      this.userService.addOne(userDTO),
      HttpStatus.CREATED
    );
  }

  @PostMapping(
    value = "/login",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
    userDTO = this.userService.login(userDTO);
    if (userDTO != null) {
      return new ResponseEntity<Object>(userDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/readOne/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> readOne(@PathVariable("userId") Long userId) {
    UserDTO userDTO = this.userService.readOne(userId);
    if (userDTO != null) {
      return new ResponseEntity<Object>(userDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(
    value = "/readOneByUsername/{username}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readOneByUsername(
    @PathVariable("username") String username
  ) {
    UserDTO userDTO = this.userService.readOneByUsername(username);
    if (userDTO != null) {
      return new ResponseEntity<Object>(userDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(
    value = "/readMany/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<UserDTO> userDTOs = this.userService.readMany(pageNumber, itemCount);
      return new ResponseEntity<Object>(userDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @GetMapping(
    value = "/readManyByType/{userType}/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readManyByType(
    @PathVariable("userType") String type,
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<UserDTO> userDTOs =
        this.userService.readManyByType(type, pageNumber, itemCount);
      return new ResponseEntity<Object>(userDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @PutMapping(
    value = "/updateOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> updateOne(@RequestBody UserDTO userDTO) {
    userDTO = this.userService.updateOne(userDTO);
    if (userDTO != null) {
      return new ResponseEntity<Object>(userDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(userDTO, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value = "/removeOne/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public void removeOne(@PathVariable("userId") Long userId) {
    this.userService.removeOne(userId);
  }
}
