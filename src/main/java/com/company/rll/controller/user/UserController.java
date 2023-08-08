package com.company.rll.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.rll.entity.user.UserEntity;
import com.company.rll.service.user.UserService;



@RestController
@RequestMapping("/userlogin")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService us;


	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String loginvalidation(@RequestBody UserEntity u) {
		return us.loginvalidation(u.getUsername(), u.getPassword());
	}
	
	@GetMapping(value="/viewAll" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserEntity> showall(){
		return us.showall();
	}
	@PostMapping(value="/register" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public String register(@RequestBody UserEntity u) {
		return us.register(u);
	}
	
}

