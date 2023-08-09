package com.company.rll.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.rll.service.admin.AdminService;


@RestController
@RequestMapping("AdminEntity")
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService AdminService;

	@PostMapping(value = "register",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody Admin AdminEntity) {
		System.out.println(AdminEntity);
		return  AdminService.register(AdminEntity); 
		}
}

