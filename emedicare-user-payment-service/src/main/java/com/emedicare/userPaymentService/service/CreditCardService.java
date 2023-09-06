package com.emedicare.userPaymentService.service;

import com.emedicare.userPaymentService.entity.CreditCardEntity;
import com.emedicare.userPaymentService.repository.CreditCardRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "CreditCardService")
@Scope(value = "singleton")
public class CreditCardService {
  @Autowired
  @Qualifier(value = "CreditCardRepository")
  private CreditCardRepository creditCardRepository;

  public CreditCardEntity addOne(CreditCardEntity creditCard) {
    return creditCardRepository.save(creditCard);
  }

  public CreditCardEntity readOne(Long creditCardId) {
    Optional<CreditCardEntity> creditCardOptional = creditCardRepository.findById(
      creditCardId
    );
    if (creditCardOptional.isPresent()) {
      return creditCardOptional.get();
    }
    return null;
  }

  public List<CreditCardEntity> readAll() {
    return creditCardRepository.findAll();
  }

  public CreditCardEntity updateOne(CreditCardEntity creditCard) {
    Optional<CreditCardEntity> creditCardOptional =
      this.creditCardRepository.findById(creditCard.getCreditCardId());
    if (creditCardOptional.isPresent()) {
      return creditCardRepository.save(creditCard);
    }
    return null;
  }

  public void deleteOne(Long creditCardId) {
    creditCardRepository.deleteById(creditCardId);
  }
}
