package com.emedicare.userAddressService.service;

import com.emedicare.userAddressService.dto.UserAddressDTO;
import com.emedicare.userAddressService.entity.UserAddressEntity;
import com.emedicare.userAddressService.repository.UserAddressRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "UserAddressService")
public class UserAddressService {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  @Qualifier(value = "UserAddressRepository")
  UserAddressRepository userAddressRepository;

  public UserAddressDTO addOne(UserAddressDTO userAddressDTO) {
    UserAddressEntity userAddressEntity = new UserAddressEntity();
    this.modelMapper.map(userAddressDTO, userAddressEntity);
    userAddressEntity = this.userAddressRepository.save(userAddressEntity);
    this.modelMapper.map(userAddressEntity, userAddressDTO);
    return userAddressDTO;
  }

  public UserAddressDTO readOne(Long userAddressId) {
    Optional<UserAddressEntity> userAddressEntityOptional =
      this.userAddressRepository.findById(userAddressId);
    if (userAddressEntityOptional.isPresent()) {
      UserAddressDTO userAddressDTO = new UserAddressDTO();
      this.modelMapper.map(userAddressEntityOptional.get(), userAddressDTO);
      return userAddressDTO;
    }
    return null;
  }

  public List<UserAddressDTO> readMany(Long userId) {
    List<UserAddressEntity> userAddressList =
      this.userAddressRepository.findAllByUserId(userId);
    List<UserAddressDTO> userAddressDTOs = new LinkedList<UserAddressDTO>();
    userAddressList
      .stream()
      .forEach(
        locationEntity -> {
          UserAddressDTO productDTO = new UserAddressDTO();
          this.modelMapper.map(locationEntity, productDTO);
          userAddressDTOs.add(productDTO);
        }
      );
    return userAddressDTOs;
  }

  public UserAddressDTO updateOne(UserAddressDTO userAddressDTO) {
    Optional<UserAddressEntity> userAddressEntityOptional =
      this.userAddressRepository.findById(userAddressDTO.getUserAddressId());
    if (userAddressEntityOptional.isPresent()) {
      this.modelMapper.map(userAddressDTO, userAddressEntityOptional.get());
      userAddressEntityOptional.get().setDateModified(Timestamp.from(Instant.now()));
      this.userAddressRepository.save(userAddressEntityOptional.get());
      this.modelMapper.map(userAddressEntityOptional.get(), userAddressDTO);
      return userAddressDTO;
    }
    return null;
  }

  public void removeOne(long userAddressId) {
    this.userAddressRepository.deleteById(userAddressId);
  }
}
