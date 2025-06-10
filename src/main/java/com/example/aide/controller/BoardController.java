/*
package com.example.aide.controller;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.BoardDTO;
import com.example.aide.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/write")
    public ResponseEntity<ApiResponseDTO> writeBoard(@RequestBody BoardDTO boardDTO) {
        ApiResponseDTO result = boardService.writeBoard(boardDTO);
        if(result.getMessage().equals("fail")) {
            return ResponseEntity.ok(new ApiResponseDTO(false,"게시판 생성 실패"));
        }
        return ResponseEntity.ok(new ApiResponseDTO(true, "게시판 생성 성공"));
    }
}
*/
