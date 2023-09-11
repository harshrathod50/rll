package com.emedicare.shippingservice.service;

import com.emedicare.shippingservice.entity.UserEntity;
import com.emedicare.shippingservice.repository.UserRepository;
import java.util.List;
// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "UserService")
@Scope(value = "singleton")
public class UserService {
  // @Autowired
  // private ModelMapper modelMapper;

  @Autowired
  @Qualifier(value = "UserRepository")
  private UserRepository userRepository;

  public UserEntity pushtoship(UserEntity userEntity) {
    return this.userRepository.save(userEntity);
  }

  public List<UserEntity> ShowAlldetails() {
    return this.userRepository.findAll();
  }
}
