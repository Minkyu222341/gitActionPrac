package com.sparta.mini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/realTest")
    public String autoBuild() {
        return "오토빌드";
    }
}

