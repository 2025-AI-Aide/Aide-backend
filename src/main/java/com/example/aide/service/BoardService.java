/*
package com.example.aide.service;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.BoardDTO;
import com.example.aide.entity.Board;
import com.example.aide.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public ApiResponseDTO writeBoard(BoardDTO boardDTO) {
        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .build();

        boardRepository.save(board);
        return new ApiResponseDTO(true, "게시판 생성 성공");
    }
}
*/
