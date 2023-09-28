package com.arrowsmith.sakiladb.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://main.d34jypsxbhc933.amplifyapp.com")
public class RootController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}