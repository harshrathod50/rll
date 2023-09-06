package com.emedicare.paymentService.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component(value = "CreditCardDTO")
public class CreditCardDTO implements Serializable {
  private Long creditCardId;
  private String cardHolderName;
  private String cardNumber;
  private Byte expiryMonth;
  private Short expiryYear;
  private Short cvv;

  public Long getCreditCardId() {
    return creditCardId;
  }

  public void setCreditCardId(Long creditCardId) {
    this.creditCardId = creditCardId;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Byte getExpiryMonth() {
    return expiryMonth;
  }

  public void setExpiryMonth(Byte expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  public Short getExpiryYear() {
    return expiryYear;
  }

  public void setExpiryYear(Short expiryYear) {
    this.expiryYear = expiryYear;
  }

  public Short getCvv() {
    return cvv;
  }

  public void setCvv(Short cvv) {
    this.cvv = cvv;
  }
}
