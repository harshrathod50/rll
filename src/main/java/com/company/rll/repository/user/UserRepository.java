package com.company.rll.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.rll.entity.user.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
	public  UserEntity findByuname(String uname);
}
