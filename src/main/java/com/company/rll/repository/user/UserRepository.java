package com.company.rll.repository.user;

import com.company.rll.entity.user.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query("FROM user WHERE username = ?1")
  Optional<UserEntity> findByUsername(String username);
}
