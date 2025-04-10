package com.example.aide.controller;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.UserDTO;
import com.example.aide.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor // 생성자 자동 생성
public class UserController {
    private final UserService userService;


    @PostMapping("/signup")
    public ApiResponseDTO signup(@RequestBody UserDTO userDTO) {
        Boolean success = userService.create(userDTO);
        if (success) {
            return new ApiResponseDTO(success, "회원가입을 성공했습니다.");
        }
        else {
            return new ApiResponseDTO(false, "회원가입 실패");
        }
    }
}
