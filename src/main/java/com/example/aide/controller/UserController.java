package com.example.aide.controller;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.UserDTO;
import com.example.aide.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponseDTO> signup(@RequestBody UserDTO userDTO) {
        Boolean success = userService.create(userDTO);
        if (success) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8") // ✅ 중요
                    .body(new ApiResponseDTO(success, "회원가입 성공"));

//                    new ApiResponseDTO(success, "회원가입을 성공했습니다.");
        }
        else {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8") // ✅ 중요
                    .body(new ApiResponseDTO(false, "회원가입 실패"));
        }
    }

//    @PostMapping("/ocr")
//    public ApiResponseDTO ocrDataProcess(){
//
//    }
}
