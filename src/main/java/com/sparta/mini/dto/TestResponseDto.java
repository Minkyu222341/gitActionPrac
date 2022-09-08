package com.sparta.mini.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TestResponseDto {

    private String token;
    private String username;

    @Builder
    public TestResponseDto(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
