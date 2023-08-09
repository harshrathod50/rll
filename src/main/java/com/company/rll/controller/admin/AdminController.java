package com.company.rll.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.service.admin.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminEntity> register(@RequestBody AdminEntity adminEntity) {
		//System.out.println(AdminEntity);
		AdminEntity a=adminService.register(adminEntity);
      return new ResponseEntity<AdminEntity>(adminEntity, HttpStatus.CREATED);
		}
}

