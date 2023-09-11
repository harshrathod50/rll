package com.emedicare.shippingservice.repository;

import com.emedicare.shippingservice.entity.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "UserRepository")
@Scope(value = "singleton")
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
