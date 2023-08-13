package com.company.rll.controller.admin;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

  @PutMapping(value = "/login")
  public ResponseEntity<Object> login(@RequestBody AdminEntity adminEntity) {
    AdminEntity a = adminService.login(adminEntity);
    if (a != null) {
      return new ResponseEntity<Object>(a, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/remove_one/{adminId}")
  @ResponseStatus(HttpStatus.OK)
  public void remove(@PathVariable("adminId") long adminId) {
    this.adminService.remove(adminId);
  }
}
