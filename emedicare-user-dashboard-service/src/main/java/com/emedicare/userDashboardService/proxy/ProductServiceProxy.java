package com.emedicare.userDashboardService.proxy;

import com.emedicare.userDashboardService.dto.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.util.ArrayList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service")
public interface ProductServiceProxy {
  @GetMapping(
    value = "/product/readOne/{productId}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "readOne", fallbackMethod = "fallbackReadOne")
  @Retry(name = "product-service")
  public ResponseEntity<Object> readOne(@PathVariable("productId") Long productId);

  public default ResponseEntity<Object> fallbackReadOne(Long productId, Exception e) {
    return new ResponseEntity<Object>(
      new ProductDTO(null, null, null, null, null),
      HttpStatus.OK
    );
  }

  @GetMapping(
    value = "/product/readMany/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @CircuitBreaker(name = "readMany", fallbackMethod = "fallbackReadMany")
  @Retry(name = "product-service")
  public ResponseEntity<Object> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  );

  public default ResponseEntity<Object> fallbackReadMany(
    Integer pageNumber,
    Integer itemCount,
    Exception e
  ) {
    return new ResponseEntity<Object>(new ArrayList<ProductDTO>(0), HttpStatus.OK);
  }
}
