package com.example.aide.controller;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.OCRResponseDTO;
import com.example.aide.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @PostMapping("/upload")
    public ResponseEntity<ApiResponseDTO> uploadContract(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        if(file == null || file.isEmpty()) {
            return ResponseEntity.ok(new ApiResponseDTO(false, "파일이 비어있습니다"));
        }
        ApiResponseDTO result = contractService.uploadFile(file).getBody();
        return ResponseEntity.ok(new ApiResponseDTO(true, result.getMessage()));
    }
}