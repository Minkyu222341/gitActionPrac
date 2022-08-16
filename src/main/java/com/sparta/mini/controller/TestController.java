package com.sparta.mini.controller;

import com.sparta.mini.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class TestController {

    private final AuthService authService;

    @PostMapping("/nickname")
    public String loginNickname() {
        return authService.getLoginNickname();
    }


    @GetMapping("/auto")
    public String autoBuild2() {
        return "됐나 ?";
    }
}

