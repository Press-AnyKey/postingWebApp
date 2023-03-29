package com.example.webapptest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String application;

    public Application() {
    }

    public Application(String application) {
        this.application = application;
    }

    public Application(Long id, String application) {
        this.id = id;
        this.application = application;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", application='" + application + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }
}
