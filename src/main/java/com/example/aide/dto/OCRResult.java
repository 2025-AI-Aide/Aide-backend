package com.example.aide.dto;

import lombok.Getter;
import lombok.Setter;
public class OCRResult {    
    private String text;
    private String analysis;

    // Getters & Setters
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getAnalysis() {
        return analysis;
    }
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }
}