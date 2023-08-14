package com.company.rll.controller.user;

import com.company.rll.entity.user.UserEntity;
import com.company.rll.service.user.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
  @Autowired
  UserService userService;

  @PutMapping("/login")
  public ResponseEntity<Object> loginvalidation(@RequestBody UserEntity u) {
    UserEntity user = this.userService.loginvalidation(u.getUsername(), u.getPassword());
    if (user != null) {
      return new ResponseEntity<Object>(user, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(value = "/viewAll", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> showall() {
    return this.userService.showall();
  }

  @PostMapping(
    value = "/register",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<UserEntity> register(@RequestBody UserEntity u) {
    return new ResponseEntity<UserEntity>(
      this.userService.register(u),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/totalNumberOfUsers")
  public ResponseEntity<Long> totalNumberOfUsers() {
    return new ResponseEntity<Long>(this.userService.totalNumberOfUsers(), HttpStatus.OK);
  }

  @DeleteMapping("/remove_one/{userId}")
  @ResponseStatus(HttpStatus.OK)
  public void removeOne(@PathVariable("userId") long userId) {
    this.userService.removeOne(userId);
  }
}
