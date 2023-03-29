package com.example.webapptest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String materialDescription;
    private Double amountLc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    public Item() {
    }

    public Item(String materialDescription, Double amountLc, Currency currency) {
        this.materialDescription = materialDescription;
        this.amountLc = amountLc;
        this.currency = currency;
    }

    public Item(Long id, String materialDescription, Double amountLc, Currency currency) {
        this.id = id;
        this.materialDescription = materialDescription;
        this.amountLc = amountLc;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", materialDescription='" + materialDescription + '\'' +
                ", amountLC='" + amountLc + '\'' +
                ", currency=" + currency +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public Double getAmountLc() {
        return amountLc;
    }

    public void setAmountLc(Double amountLC) {
        this.amountLc = amountLC;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
