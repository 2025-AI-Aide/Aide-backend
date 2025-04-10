package com.example.aide.controller;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping("/contract/upload")
    public ResponseEntity<ApiResponseDTO> uploadContract(@RequestParam("file") MultipartFile file) {
        boolean result = contractService.uploadFile(file);
        return ResponseEntity.ok(new ApiResponseDTO(result, "이미지 업로드 성공!"));
    }
}