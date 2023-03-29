package com.example.webapptest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Console {
    public static void main(String[] args) {
        System.out.println("Hello");
        String date = "21.07.2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate docDate = LocalDate.parse(date,formatter);
        System.out.println(docDate);
    }
}
