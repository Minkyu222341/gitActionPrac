package com.sparta.mini.controller;


import com.sparta.mini.dto.MemberRequestDto;
import com.sparta.mini.dto.MemberResponseDto;
import com.sparta.mini.dto.TokenDto;
import com.sparta.mini.model.Member;
import com.sparta.mini.repository.MemberRepository;
import com.sparta.mini.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;
    private final MemberRepository memberRepository;


    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberRequestDto memberRequestDto, HttpServletResponse response) {
        TokenDto tokenDto = authService.login(memberRequestDto);
        response.setHeader("Authorization", "Bearer " + tokenDto.getAccessToken());
//        response.setHeader("Refresh-Token", tokenDto.getRefreshToken());
        response.setHeader("Access-Token-Expire-Time", String.valueOf(tokenDto.getAccessTokenExpiresIn()));

        Cookie cookie = new Cookie("mycookie", tokenDto.getAccessToken());
        response.addCookie(cookie);
        final Optional<Member> loginUsername = memberRepository.findByUsername(memberRequestDto.getUsername());
                            //로그인한 유저의 닉네임
        return loginUsername.get().getNickname();
    }

    @PostMapping("/validate")
    public boolean validateUsername(@RequestBody MemberRequestDto memberRequestDto) {
        return authService.validateUsername(memberRequestDto);
    }

    @GetMapping("/nickname")
    public String loginNickname() {
        return authService.getLoginNickname();
    }


//    @PostMapping("/reissue")  //재발급을 위한 로직
//    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
//        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
//    }

}
