package com.example.webapptest.repository;

import com.example.webapptest.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
    Application findByApplication(String application);
}
