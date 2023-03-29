package com.example.webapptest.controller;

import com.example.webapptest.util.FillDBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("db")
public class DBController {
    @Autowired
    private FillDBUtil fillDBUtil;

    @GetMapping(value = "/parser")
    public String parserTest() {
        fillDBUtil.fillDBFromLogins();
        fillDBUtil.fillDBFromPosting();
        return "";
    }

}
