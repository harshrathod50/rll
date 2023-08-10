package com.company.rll.repository.admin;

import com.company.rll.entity.admin.AdminEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
  @Query("FROM admin WHERE username = ?1")
  Optional<AdminEntity> findByUsername(String username);
}
