package com.sparta.mini.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/auto")
    public String autoBuild2() {
        return "됐나 ? 빌드 테스트";
    }
}

