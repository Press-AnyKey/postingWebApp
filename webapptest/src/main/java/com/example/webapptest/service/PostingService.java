package com.example.webapptest.service;


import com.example.webapptest.model.Posting;
import com.example.webapptest.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PostingService {
    @Autowired
    private PostingRepository postingRepository;

    public Posting findPostingById(long id) {
        var result = postingRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public void deleteAll() {
        postingRepository.deleteAll();
    }

    public List<Posting> findPostingByYear(int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate docDateFrom = LocalDate.parse("01.01." + year,formatter);
        LocalDate docDateTo = LocalDate.parse("31.12." + year,formatter);
        return  postingRepository.findByPstngDateBetween(docDateFrom, docDateTo);
    }


    public List<Posting> findPostingByYearAndAuth(int year, Boolean auth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate docDateFrom = LocalDate.parse("01.01." + year,formatter);
        LocalDate docDateTo = LocalDate.parse("31.12." + year,formatter);
        return  postingRepository.findByPstngDateBetweenAndAuthorizedDelivery(docDateFrom, docDateTo, auth);
    }

}
