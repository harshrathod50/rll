package com.company.rll.controller.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.rll.entity.user.*;
import com.company.rll.service.user.*;



@RestController
@RequestMapping("/userlogin")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService us;

	@GetMapping(value="/login" , consumes=MediaType.APPLICATION_JSON_VALUE)
	public String loginvalidation(@RequestBody UserEntity u) {
		return us.loginvalidation(u.getUsername(), u.getPassword());
	}
	
	@GetMapping(value="/viewAll" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserEntity> showall(){
		return us.showall();
	}
	
	
}

