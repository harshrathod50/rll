package com.emedicare.userCartService.service;

import com.emedicare.userCartService.dto.CartItemDTO;
import com.emedicare.userCartService.dto.ProductDTO;
import com.emedicare.userCartService.dto.UserCartDTO;
import com.emedicare.userCartService.entity.CartItemEntity;
import com.emedicare.userCartService.entity.UserCartEntity;
import com.emedicare.userCartService.repository.UserCartRepository;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "UserCartService")
public class UserCartService {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  @Qualifier(value = "UserCartRepository")
  UserCartRepository userCartRepository;

  public UserCartEntity addOne(Long userCartDTO) {
    UserCartEntity newUserCartEntity = new UserCartEntity();
    this.modelMapper.map(userCartDTO, newUserCartEntity);
    newUserCartEntity = this.userCartRepository.save(newUserCartEntity);
    return newUserCartEntity;
  }

  public void addOneProduct(CartItemDTO cartItemDTO) {
    Optional<UserCartEntity> userCartEntityOptional = userCartRepository.findById(
      cartItemDTO.getUserCartId()
    );
    if (userCartEntityOptional.isPresent()) {
      List<CartItemEntity> items = userCartEntityOptional.get().getItems();
      CartItemEntity newItem = new CartItemEntity();
      newItem.setQuantity(cartItemDTO.getQuantity());
      newItem.setProductId(cartItemDTO.getProductId());
      items.add(newItem);
      this.userCartRepository.save(userCartEntityOptional.get());
    }
  }

  public UserCartDTO readOne(Long userCartId) {
    Optional<UserCartEntity> userCartEntityOptional = userCartRepository.findById(
      userCartId
    );
    if (userCartEntityOptional.isPresent()) {
      UserCartDTO userCartDTO = new UserCartDTO();
      this.modelMapper.map(userCartEntityOptional.get(), userCartDTO);
      return userCartDTO;
    }
    return null;
  }

  public UserCartDTO readOneByUserId(Long userId) {
    UserCartDTO userCartDTO = new UserCartDTO();
    Optional<UserCartEntity> userCartEntityOptional = userCartRepository.findByUserId(
      userId
    );
    if (!userCartEntityOptional.isPresent()) {
      UserCartEntity newUserCartEntity = new UserCartEntity();
      newUserCartEntity.setUserId(userId);
      newUserCartEntity = this.userCartRepository.save(newUserCartEntity);
      this.modelMapper.map(newUserCartEntity, userCartDTO);
      return userCartDTO;
    }
    this.modelMapper.map(userCartEntityOptional.get(), userCartDTO);
    return userCartDTO;
  }
}
