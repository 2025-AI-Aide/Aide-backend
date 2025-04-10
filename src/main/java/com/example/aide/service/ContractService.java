package com.example.aide.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ContractService {
    public Boolean uploadFile(MultipartFile file) {
        // 받아온 파일 처리
        // 1. OCR API 호출해서 텍스트 추출
        // 2. 추출한 텍스트를 인공지능 서버에 전송
        return true;
    }
}
