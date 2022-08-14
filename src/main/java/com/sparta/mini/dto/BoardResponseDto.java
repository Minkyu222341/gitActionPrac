package com.sparta.mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Builder
public class BoardResponseDto {

    private Long board_id;
    private String title;
    private String nickname;
    private String content;
    @CreatedDate //생성시간
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime createdAt; //LocalDateTime 시간을 나타내는 자료형


}
