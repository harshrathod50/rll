package com.emedicare.paymentService.controller;

import com.emedicare.paymentService.dto.CreditCardDTO;
import com.emedicare.paymentService.service.ProductService;
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

@RestController(value = "CreditCardController")
@Scope(value = "request")
@CrossOrigin(value = "*")
@RequestMapping(value = "/product")
public class CreditCardController {
  @Autowired
  @Qualifier(value = "CreditCardService")
  private ProductService creditCardService;

  @PostMapping(
    value = "/addOne",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<CreditCardDTO> addOne(@RequestBody CreditCardDTO creditCard) {
    return new ResponseEntity<CreditCardDTO>(
      this.creditCardService.addOne(creditCard),
      HttpStatus.CREATED
    );
  }

  @GetMapping(
    value = "/readOne/{creditCardId}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readOne(
    @PathVariable("creditCardId") Long creaditCardId
  ) {
    ProductDTO productDTO = this.productService.readOne(creditCardId);
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
    value = "/readManyByBrand/{productBrand}/{pageNumber}/{itemCount}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> readManyByBrand(
    @PathVariable("productBrand") String productBrand,
    @PathVariable("pageNumber") Integer pageNumber,
    @PathVariable("itemCount") Integer itemCount
  ) {
    if (pageNumber >= 0 && itemCount > 0) {
      List<ProductDTO> productDTOs =
        this.productService.readManyByBrand(productBrand, pageNumber, itemCount);
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
