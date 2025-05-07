package com.example.aide.service;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.OCRResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ContractService {
    // 받아온 파일 처리
    // 1. OCR API 호출해서 텍스트 추출: 거의 다 됨
    // 2. 추출한 텍스트를 인공지능 서버에 전송: 미완성
    private final OCRService ocrService;
    public ResponseEntity<ApiResponseDTO> uploadFile(MultipartFile file) {
        OCRResponseDTO data = ocrService.callOCRFunc(file).getBody();
        return ResponseEntity.ok(new ApiResponseDTO(true, data.getOcrData(), data.getFile() ));
    }
}
