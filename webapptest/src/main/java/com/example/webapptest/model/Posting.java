package com.example.webapptest.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Posting {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matDoc;
    private LocalDate docDate;
    private LocalDate pstngDate;
    private String userName;
    private Boolean authorizedDelivery;

    public Posting() {
    }

    public Posting(Long matDoc, LocalDate docDate, LocalDate pstngDate, String userName, Boolean authorizedDelivery) {
        this.matDoc = matDoc;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.userName = userName;
        this.authorizedDelivery = authorizedDelivery;
    }

    public Posting(Long id, Long matDoc, LocalDate docDate, LocalDate pstngDate, String userName, Boolean authorizedDelivery) {
        this.id = id;
        this.matDoc = matDoc;
        this.docDate = docDate;
        this.pstngDate = pstngDate;
        this.userName = userName;
        this.authorizedDelivery = authorizedDelivery;
    }

    @Override
    public String toString() {
        return "Posting{" +
                "id=" + id +
                ", matDoc=" + matDoc +
                ", docDate=" + docDate +
                ", pstngDate=" + pstngDate +
                ", userName='" + userName + '\'' +
                ", authorizedDelivery=" + authorizedDelivery +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatDoc() {
        return matDoc;
    }

    public void setMatDoc(Long matDoc) {
        this.matDoc = matDoc;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
        this.docDate = docDate;
    }

    public LocalDate getPstngDate() {
        return pstngDate;
    }

    public void setPstngDate(LocalDate pstngDate) {
        this.pstngDate = pstngDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getAuthorizedDelivery() {
        return authorizedDelivery;
    }

    public void setAuthorizedDelivery(Boolean authorizedDelivery) {
        this.authorizedDelivery = authorizedDelivery;
    }
}
