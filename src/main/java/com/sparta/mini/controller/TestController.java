package com.sparta.mini.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "테스트";
    }
    @GetMapping("/test2")
    public String test2() {
        return "테스트2번";
    }
}

