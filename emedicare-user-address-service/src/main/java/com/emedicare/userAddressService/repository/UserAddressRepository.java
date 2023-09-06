package com.emedicare.userAddressService.repository;

import com.emedicare.userAddressService.entity.UserAddressEntity;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "UserAddressRepository")
@Scope(value = "singleton")
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {
  @Query(value = "FROM UserAddressEntity u WHERE u.userId=?1")
  List<UserAddressEntity> findAllByUserId(Long userId);
}
