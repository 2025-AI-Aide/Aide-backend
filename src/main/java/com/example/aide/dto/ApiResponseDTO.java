package com.example.aide.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

public class ApiResponseDTO {
    private Boolean success;
    private String message;

    public ApiResponseDTO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
