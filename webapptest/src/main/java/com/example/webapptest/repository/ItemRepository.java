package com.example.webapptest.repository;

import com.example.webapptest.model.Currency;
import com.example.webapptest.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
    Item findItemByMaterialDescriptionAndAmountLcAndCurrency(
            String materialDescription, double amountLc, Currency currency);
}
