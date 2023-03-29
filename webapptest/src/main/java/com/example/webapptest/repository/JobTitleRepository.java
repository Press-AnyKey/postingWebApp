package com.example.webapptest.repository;

import com.example.webapptest.model.JobTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends CrudRepository<JobTitle, Integer> {
    JobTitle findByJobTitle (String jobTitle);
}
