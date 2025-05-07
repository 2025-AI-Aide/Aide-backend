package com.example.aide.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class OCRResponseDTO {
    private MultipartFile file; // 파일
    private String ocrData; // OCR에서 추출한 데이터

    public OCRResponseDTO(MultipartFile file, String ocrData) {
        this.file = file;
        this.ocrData = ocrData;
    }
}
