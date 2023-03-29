package com.example.webapptest.repository;

import com.example.webapptest.model.Posting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostingRepository  extends CrudRepository<Posting, Long> {
    Posting findByMatDoc(Long matDoc);
    List<Posting> findByPstngDateBetween(LocalDate docDateFrom, LocalDate docDateTo);
    List<Posting> findByPstngDateBetweenAndAuthorizedDelivery(
            LocalDate docDateFrom, LocalDate docDateTo, Boolean authorizedDelivery);

}
