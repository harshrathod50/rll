package com.emedicare.paymentService.service;

import com.rathod.harsh.store.dto.ProductDTO;
import com.rathod.harsh.store.entity.ProductEntity;
import com.rathod.harsh.store.repository.ProductRepository;
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

@Service(value = "ProductService")
@Scope(value = "singleton")
public class ProductService {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  @Qualifier(value = "ProductRepository")
  private ProductRepository productRepository;

  public ProductDTO addOne(ProductDTO productDTO) {
    ProductEntity productEntity = new ProductEntity();
    this.modelMapper.map(productDTO, productEntity);
    productEntity = this.productRepository.save(productEntity);
    this.modelMapper.map(productEntity, productDTO);
    return productDTO;
  }

  public ProductDTO readOne(long productId) {
    Optional<ProductEntity> productEntityOptional =
      this.productRepository.findById(productId);
    if (productEntityOptional.isPresent()) {
      ProductDTO locationDTO = new ProductDTO();
      this.modelMapper.map(productEntityOptional.get(), locationDTO);
      return locationDTO;
    }
    return null;
  }

  public List<ProductDTO> readMany(Integer pageNumber, Integer itemCount) {
    Page<ProductEntity> productEntitiesPage =
      this.productRepository.findAll(PageRequest.of(pageNumber, itemCount));
    List<ProductDTO> productDTOs = new LinkedList<ProductDTO>();
    productEntitiesPage
      .stream()
      .forEach(
        locationEntity -> {
          ProductDTO productDTO = new ProductDTO();
          this.modelMapper.map(locationEntity, productDTO);
          productDTOs.add(productDTO);
        }
      );
    return productDTOs;
  }

  public List<ProductDTO> readManyByName(
    String productName,
    Integer pageNumber,
    Integer itemCount
  ) {
    Page<ProductEntity> productEntitiesPage =
      this.productRepository.findAllByName(
          productName,
          PageRequest.of(pageNumber, itemCount)
        );
    List<ProductDTO> productDTOs = new LinkedList<ProductDTO>();
    productEntitiesPage
      .stream()
      .forEach(
        locationEntity -> {
          ProductDTO productDTO = new ProductDTO();
          this.modelMapper.map(locationEntity, productDTO);
          productDTOs.add(productDTO);
        }
      );
    return productDTOs;
  }

  public List<ProductDTO> readManyByBrand(
    String productBrand,
    Integer pageNumber,
    Integer itemCount
  ) {
    Page<ProductEntity> productEntitiesPage =
      this.productRepository.findAllByBrand(
          productBrand,
          PageRequest.of(pageNumber, itemCount)
        );
    List<ProductDTO> productDTOs = new LinkedList<ProductDTO>();
    productEntitiesPage
      .stream()
      .forEach(
        locationEntity -> {
          ProductDTO productDTO = new ProductDTO();
          this.modelMapper.map(locationEntity, productDTO);
          productDTOs.add(productDTO);
        }
      );
    return productDTOs;
  }

  public List<ProductDTO> readManyByPrice(
    Double productPrice,
    Integer pageNumber,
    Integer itemCount
  ) {
    Page<ProductEntity> productEntitiesPage =
      this.productRepository.findAllByPrice(
          productPrice,
          PageRequest.of(pageNumber, itemCount)
        );
    List<ProductDTO> productDTOs = new LinkedList<ProductDTO>();
    productEntitiesPage
      .stream()
      .forEach(
        locationEntity -> {
          ProductDTO productDTO = new ProductDTO();
          this.modelMapper.map(locationEntity, productDTO);
          productDTOs.add(productDTO);
        }
      );
    return productDTOs;
  }

  public ProductDTO updateOne(ProductDTO productDTO) {
    Optional<ProductEntity> productEntityOptional =
      this.productRepository.findById(productDTO.getProductId());
    if (productEntityOptional.isPresent()) {
      this.modelMapper.map(productDTO, productEntityOptional.get());
      productEntityOptional.get().setDateModified(Timestamp.from(Instant.now()));
      this.productRepository.save(productEntityOptional.get());
      this.modelMapper.map(productEntityOptional.get(), productDTO);
      return productDTO;
    }
    return null;
  }

  public void removeOne(long productId) {
    this.productRepository.deleteById(productId);
  }
}
