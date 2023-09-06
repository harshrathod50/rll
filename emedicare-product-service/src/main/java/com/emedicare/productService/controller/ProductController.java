package com.emedicare.productService.controller;

import com.emedicare.productService.dto.ProductDTO;
import com.emedicare.productService.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "ProductController")
@Scope(value = "request")
@CrossOrigin(value = "*")
@RequestMapping(value = "/product")
public class ProductController {
  @Autowired
  @Qualifier(value = "ProductService")
  private ProductService productService;

  @PostMapping(
    value = "/addOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<ProductDTO> addOne(@RequestBody ProductDTO product) {
    return new ResponseEntity<ProductDTO>(
      this.productService.addOne(product),
      HttpStatus.CREATED
    );
  }

  @GetMapping(value = "/readOne/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> readOne(@PathVariable("productId") Long productId) {
    ProductDTO productDTO = this.productService.readOne(productId);
    if (productDTO != null) {
      return new ResponseEntity<Object>(productDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping(
    value = "/readMany/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readMany(
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<ProductDTO> productDTOs = this.productService.readMany(pageNumber, itemCount);
      return new ResponseEntity<Object>(productDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @GetMapping(
    value = "/readManyByName/{productName}/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readManyByName(
    @PathVariable("productName") String productName,
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<ProductDTO> productDTOs =
        this.productService.readManyByName(productName, pageNumber, itemCount);
      return new ResponseEntity<Object>(productDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @GetMapping(
    value = "/readManyByType/{productType}/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readManyByType(
    @PathVariable("productType") String productType,
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<ProductDTO> productDTOs =
        this.productService.readManyByType(productType, pageNumber, itemCount);
      return new ResponseEntity<Object>(productDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @GetMapping(
    value = "/readManyByPrice/{productPrice}/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readManyByPrice(
    @PathVariable("productPrice") Double productPrice,
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<ProductDTO> productDTOs =
        this.productService.readManyByPrice(productPrice, pageNumber, itemCount);
      return new ResponseEntity<Object>(productDTOs, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
  }

  @PutMapping(
    value = "/updateOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> updateOne(@RequestBody ProductDTO productDTO) {
    productDTO = this.productService.updateOne(productDTO);
    if (productDTO != null) {
      return new ResponseEntity<Object>(productDTO, HttpStatus.OK);
    }
    return new ResponseEntity<Object>(productDTO, HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value = "/removeOne/{productId}")
  @ResponseStatus(HttpStatus.OK)
  public void removeOne(@PathVariable("productId") Long productId) {
    productService.removeOne(productId);
  }
}
