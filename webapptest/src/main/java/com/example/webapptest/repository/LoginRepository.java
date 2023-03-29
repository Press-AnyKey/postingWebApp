package com.example.webapptest.repository;

import com.example.webapptest.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer>{
    List<Login> findByAppAccountNameAndIsActive(String appAccountName, Boolean isActive);
    List<Login> findByAppAccountName(String appAccountName);
}
