package com.emedicare.userRegisterService.service;

import com.emedicare.userRegisterService.dto.UserDTO;
import com.emedicare.userRegisterService.entity.UserEntity;
import com.emedicare.userRegisterService.repository.UserRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service(value = "UserService")
@Scope(value = "singleton")
public class UserService {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  @Qualifier(value = "UserRepository")
  private UserRepository userRepository;

  public UserDTO addOne(UserDTO userDTO) {
    UserEntity userEntity = new UserEntity();
    this.modelMapper.map(userDTO, userEntity);
    userEntity = this.userRepository.save(userEntity);
    this.modelMapper.map(userEntity, userDTO);
    return userDTO;
  }

  public UserDTO readOne(Long productId) {
    Optional<UserEntity> userEntityOptional = this.userRepository.findById(productId);
    if (userEntityOptional.isPresent()) {
      UserDTO userDTO = new UserDTO();
      this.modelMapper.map(userEntityOptional.get(), userDTO);
      return userDTO;
    }
    return null;
  }

  public UserDTO readOneByUsername(String username) {
    Optional<UserEntity> userEntityOptional =
      this.userRepository.findByUsername(username);
    if (userEntityOptional.isPresent()) {
      UserDTO userDTO = new UserDTO();
      this.modelMapper.map(userEntityOptional.get(), userDTO);
      return userDTO;
    }
    return null;
  }

  public List<UserDTO> readMany(Integer pageNumber, Integer itemCount) {
    Page<UserEntity> userEntitiesPage =
      this.userRepository.findAll(PageRequest.of(pageNumber, itemCount));
    List<UserDTO> userDTOs = new LinkedList<UserDTO>();
    userEntitiesPage
      .stream()
      .forEach(
        userEntity -> {
          UserDTO userDTO = new UserDTO();
          this.modelMapper.map(userEntity, userDTO);
          userDTOs.add(userDTO);
        }
      );
    return userDTOs;
  }

  public List<UserDTO> readManyByType(
    String type,
    Integer pageNumber,
    Integer itemCount
  ) {
    Page<UserEntity> userEntitiesPage =
      this.userRepository.findAllByType(type, PageRequest.of(pageNumber, itemCount));
    List<UserDTO> userDTOs = new LinkedList<UserDTO>();
    userEntitiesPage
      .stream()
      .forEach(
        userEntity -> {
          UserDTO userDTO = new UserDTO();
          this.modelMapper.map(userEntity, userDTO);
          userDTOs.add(userDTO);
        }
      );
    return userDTOs;
  }

  public UserDTO updateOne(UserDTO userDTO) {
    Optional<UserEntity> userEntityOptional =
      this.userRepository.findById(userDTO.getUserId());
    if (userEntityOptional.isPresent()) {
      this.modelMapper.map(userDTO, userEntityOptional.get());
      userEntityOptional.get().setDateModified(Timestamp.from(Instant.now()));
      this.userRepository.save(userEntityOptional.get());
      this.modelMapper.map(userEntityOptional.get(), userDTO);
      return userDTO;
    }
    return null;
  }

  public void removeOne(Long userId) {
    this.userRepository.deleteById(userId);
  }

  public UserDTO login(UserDTO userDTO) {
    Optional<UserEntity> userEntityOptional =
      this.userRepository.findByUsername(userDTO.getUsername());
    if (userEntityOptional.isPresent()) {
      UserEntity userEntity = userEntityOptional.get();
      if (userDTO.getPassword().equals(userEntity.getPassword())) {
        this.modelMapper.map(userEntity, userDTO);
        return userDTO;
      }
    }
    return null;
  }
}
