package com.example.webapptest.util;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;

@Component
public class CSVParser {
    public List<String[]> csvFileRead(String filePath, char separator) throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader(filePath), separator, '"', 1);
        List<String[]> allRows = reader.readAll().stream().filter(row-> {
            return row.length > 0 && !row[0].isEmpty();
        }).toList();
        return allRows;
    }
}
