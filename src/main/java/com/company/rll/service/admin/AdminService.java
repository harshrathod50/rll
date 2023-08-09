package com.company.rll.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.repository.admin.AdminRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	public String register( AdminEntity adminEntity){
		Optional<AdminEntity> result = AdminRepository.findbyId(AdminEntity.getAdminId());
		if(result.isPresent()) {
			return "Email Id alreay exists";
}else {
	     if(AdminEntity.getTypeOfUser().equals("admin")){
				return "You can't create admin account";
			}else {
				      AdminRepository.save(AdminEntity);
			 }
	}
}

		
}

