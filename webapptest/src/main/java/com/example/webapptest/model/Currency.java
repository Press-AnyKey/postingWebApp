package com.example.webapptest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currency;

    public Currency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
