package com.company.rll.service.admin;

import com.company.rll.entity.admin.AdminEntity;
import com.company.rll.repository.admin.AdminRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
  @Autowired
  AdminRepository adminRepository;

  public AdminEntity register(AdminEntity adminEntity) {
    Optional<AdminEntity> result = adminRepository.findById(adminEntity.getAdminId());
    if (!result.isPresent()) {
      return adminRepository.save(adminEntity);
    }
    return null;
  }

  public AdminEntity login(AdminEntity adminEntity) {
    System.out.println(adminEntity.getPassword());
    System.out.println(adminEntity.getUsername());
    Optional<AdminEntity> result = adminRepository.findByUsername(
      adminEntity.getUsername()
    );
    if (result.isPresent()) {
      if (adminEntity.getPassword().equals(result.get().getPassword())) {
        return result.get();
      }
    }
    return null;
  }

  public void remove(long adminId) {
    this.adminRepository.deleteById(adminId);
  }
}
