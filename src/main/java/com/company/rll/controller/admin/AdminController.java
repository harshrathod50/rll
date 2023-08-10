package com.company.rll.controller.admin;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
  @Autowired
  AdminService adminService;

  @PostMapping(value = "/register")
  public ResponseEntity<AdminEntity> register(@RequestBody AdminEntity adminEntity) {
    return new ResponseEntity<AdminEntity>(
      adminService.register(adminEntity),
      HttpStatus.CREATED
    );
  }

  @GetMapping("/greet")
  public ResponseEntity<String> greet() {
    return new ResponseEntity<String>("Hello, World!", HttpStatus.OK);
  }
}
