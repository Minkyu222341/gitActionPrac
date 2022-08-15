package com.sparta.mini.controller;

import com.sparta.mini.dto.BoardRequestDto;
import com.sparta.mini.dto.BoardResponseDto;
import com.sparta.mini.model.Board;
import com.sparta.mini.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/auth")
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping
    public List<BoardResponseDto> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{board_id}")
    public BoardResponseDto getBoardDetail(@PathVariable Long board_id) {
        return boardService.getBoardDetail(board_id);
    }

    @DeleteMapping("/auth/{board_id}")
    public boolean deleteBoard(@PathVariable Long board_id) {
        return boardService.delete(board_id);
    }

    @PutMapping("/auth/{board_id}")
    public boolean updateBoard(@PathVariable Long board_id,@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.updateBoard(board_id,boardRequestDto);
    }
}
