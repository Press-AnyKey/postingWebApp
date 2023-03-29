package com.example.webapptest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bun;

    public Bun() {
    }

    public Bun(String bun) {
        this.bun = bun;
    }

    public Bun(Long id, String bun) {
        this.id = id;
        this.bun = bun;
    }

    @Override
    public String toString() {
        return "Bun{" +
                "id=" + id +
                ", bun='" + bun + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }
}
