package com.sparta.mini.service;

import com.sparta.mini.dto.BoardRequestDto;
import com.sparta.mini.dto.BoardResponseDto;
import com.sparta.mini.model.Board;
import com.sparta.mini.model.Member;
import com.sparta.mini.repository.BoardRepository;
import com.sparta.mini.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public String getLoginMemberNickname() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Member> member = memberRepository.findById(Long.valueOf(userId));
        return member.get().getNickname();
    }


    public Board createBoard(BoardRequestDto boardRequestDto) {
        String nickname = getLoginMemberNickname(); // 멤버

        Board board = Board.builder().
                title(boardRequestDto.getTitle())
                .content(boardRequestDto.getContent())
                .nickname(nickname)
                .build();

        return boardRepository.save(board);
    }

    public List<BoardResponseDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();
        for (Board board : boardList) {
            BoardResponseDto build = BoardResponseDto.builder()
                    .board_id(board.getBoard_id())
                    .nickname(board.getNickname())
                    .title(board.getTitle())
                    .createdAt(board.getCreatedAt())
                    .build();
            boardResponseDtos.add(build);
        }
        return boardResponseDtos;
    }


    public BoardResponseDto getBoardDetail(Long board_id) {
        Optional<Board> board = boardRepository.findById(board_id);
        BoardResponseDto responseDto = BoardResponseDto.builder()
                .board_id(board.get().getBoard_id())
                .nickname(board.get().getNickname())
                .title(board.get().getTitle())
                .content(board.get().getContent())
                .createdAt(board.get().getCreatedAt())
                .build();
        return responseDto;
    }


    public boolean delete(Long board_id) {
        Optional<Board> board = boardRepository.findById(board_id);
        String nickname = getLoginMemberNickname();
        if (board.get().getNickname().equals(nickname)) {
            boardRepository.deleteById(board_id);
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public boolean updateBoard(Long board_id, BoardRequestDto boardRequestDto) {
        Optional<Board> board = boardRepository.findById(board_id);
        if (board.get().getNickname().equals(getLoginMemberNickname())) {
            board.get().update(boardRequestDto.getTitle(), boardRequestDto.getContent());
            return true;
        }else{
            return false;
        }
    }
}
