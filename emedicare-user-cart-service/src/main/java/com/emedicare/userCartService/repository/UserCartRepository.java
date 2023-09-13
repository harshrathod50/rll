package com.emedicare.userCartService.repository;

import com.emedicare.userCartService.entity.UserCartEntity;
import java.util.Optional;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "UserCartRepository")
@Scope(value = "singleton")
public interface UserCartRepository extends JpaRepository<UserCartEntity, Long> {
  @Query(value = "FROM UserCartEntity uce WHERE uce.userId=?1")
  Optional<UserCartEntity> findByUserId(Long userId);
}
