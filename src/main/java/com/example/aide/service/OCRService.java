package com.example.aide.service;

import com.example.aide.dto.OCRResponseDTO;
import com.example.aide.dto.OCRResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class OCRService {
    // AI Server에 접근해야함;
    public ResponseEntity<OCRResponseDTO> callOCRFunc(MultipartFile file) {
        String apiUrl = "http://127.0.0.1:8000/file";
          
        // 파일을 포함한 요청 본문 설정
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new MultipartFileResource(file)); // MultipartFileResource는 파일을 감싸는 클래스

        // 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // HttpEntity를 사용하여 헤더와 본문을 설정
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(body, headers);

        // RestTemplate을 이용해 POST 요청을 보내고 응답을 받음
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.postForObject(apiUrl, entity, String.class);
        ObjectMapper mapper = new ObjectMapper();
        OCRResult ocrResult = null;
        try {
            ocrResult = mapper.readValue(jsonResponse, OCRResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 응답을 받아서 OCRResponseDTO 객체로 반환
        // String text = ocrResult.getText();
        String analysis;
        if (ocrResult == null) {
            analysis = "null";
        }
        else{
            analysis = ocrResult.getAnalysis();
        }

        return ResponseEntity.ok(new OCRResponseDTO(file, analysis));
        // RestTemplate restTemplate = new RestTemplate();

        // // 테스트로 일단 String 값만 받아옴
        // String result = restTemplate.postForObject(apiUrl, "{\"text\": \"" + "hello" + "\"}", String.class);
        // return ResponseEntity.ok(new OCRResponseDTO(file,result));
    }

}
