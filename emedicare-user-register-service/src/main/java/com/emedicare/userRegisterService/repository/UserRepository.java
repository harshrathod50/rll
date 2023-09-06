package com.emedicare.userRegisterService.repository;

import com.emedicare.userRegisterService.entity.UserEntity;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRepository")
@Scope(value = "singleton")
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query(value = "FROM UserEntity u WHERE u.username=?1")
  Optional<UserEntity> findByUsername(String username);

  Page<UserEntity> findAllByType(String type, Pageable page);
}
