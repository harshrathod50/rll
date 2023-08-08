package com.company.rll.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.rll.entity.user.UserEntity;
import com.company.rll.repository.user.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;

	public String loginvalidation(String uname, String pwd) {
		UserEntity u = ur.findByuname(uname);
		if (u != null) {
			if (u.getUsername() == uname && u.getPassword() == pwd) {
				return "login sucessfull";
			} else {
				return "Invalid Creds";
			}
		} else {
			return "User not found";
		}
	}

	public List<UserEntity> showall() {
		return ur.findAll();
	}
}
