package com.company.rll.repository.user;

import com.company.rll.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  public UserEntity findByuname(String uname);
}
