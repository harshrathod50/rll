package com.company.rll.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.company.rll.entity.user.UserEntity;
import com.company.rll.repository.user.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;

	public String loginvalidation(String username, String password) {
		UserEntity u = ur.findByuname(username);
		//System.out.println(u.getUsername()+","+u.getPassword());
		//System.out.println(username+","+password);
		if(u !=null) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
					return "login sucessfull";
				} else {
					return "Invalid Creds";
				}
		}
		else  {return "User Not found";}
		} 

	public List<UserEntity> showall() {
		return ur.findAll();
	}
public UserEntity register(UserEntity u)
{
	Optional<UserEntity> r = ur.findById((long) u.getUser_id());
	if(!r.isPresent()) 
	{ ur.save(u); 
	}
	return null;
}

}
		
