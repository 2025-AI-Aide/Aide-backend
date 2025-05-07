package com.example.aide.service;

import com.example.aide.dto.ApiResponseDTO;
import com.example.aide.dto.OCRResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OCRService {
    // AI Server에 접근해야함;0
    public ResponseEntity<OCRResponseDTO> callOCRFunc(MultipartFile file) {
        String apiUrl = "http://127.0.0.1:8000/file";
        RestTemplate restTemplate = new RestTemplate();
        // 테스트로 일단 String 값만 받아옴
        String result = restTemplate.postForObject(apiUrl, "{\"text\": \"" + "hello" + "\"}", String.class);
        return ResponseEntity.ok(new OCRResponseDTO(file,result));
    }

}
