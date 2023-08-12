package com.company.rll.controller.user;

import com.company.rll.entity.user.UserEntity;
import com.company.rll.service.user.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
  @Autowired
  UserService us;

  @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String loginvalidation(@RequestBody UserEntity u) {
    return us.loginvalidation(u.getUsername(), u.getPassword());
  }

  @GetMapping(value = "/viewAll", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<UserEntity> showall() {
    return us.showall();
  }

  @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
  public UserEntity register(@RequestBody UserEntity u) {
    return us.register(u);
  }

  @GetMapping("/totalNumberOfUsers")
  public ResponseEntity<Long> totalNumberOfUsers() {
    return new ResponseEntity<Long>(this.us.totalNumberOfUsers(), HttpStatus.ACCEPTED);
  }
}
