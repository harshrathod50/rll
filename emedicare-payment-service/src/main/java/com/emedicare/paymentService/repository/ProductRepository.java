package com.emedicare.paymentService.repository;

import com.rathod.harsh.store.entity.ProductEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ProductRepository")
@Scope(value = "singleton")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
  Page<ProductEntity> findAllByName(String name, Pageable page);
  Page<ProductEntity> findAllByBrand(String brand, Pageable page);
  Page<ProductEntity> findAllByPrice(Double price, Pageable page);
}
