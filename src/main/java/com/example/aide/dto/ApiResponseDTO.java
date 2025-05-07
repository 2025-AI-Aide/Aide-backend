package com.example.aide.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

public class ApiResponseDTO<T> {
    private Boolean success;
    private String message;
    private MultipartFile file;

    public ApiResponseDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public ApiResponseDTO(Boolean success, String message, MultipartFile file) {
        this.success = success;
        this.message = message;
        this.file = file;
    }
}
