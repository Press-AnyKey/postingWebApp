package com.example.webapptest.repository;

import com.example.webapptest.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    Currency findByCurrency(String currency);
}
