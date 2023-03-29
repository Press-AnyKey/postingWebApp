package com.example.webapptest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;

    public JobTitle() {
    }

    public JobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobTitle(Long id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
