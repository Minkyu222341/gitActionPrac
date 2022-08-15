package com.sparta.mini.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {

    @GetMapping("/")
    public String autoBuild() {
        return "오토빌드";
    }


    @GetMapping("/auto")
    public String autoBuild2() {
        return "됐나 ?";
    }
}

