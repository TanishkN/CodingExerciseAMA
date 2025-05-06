package com.tanishk.codingExercise.dto;

public class ShiftResponse {

    private String original;
    private String shifted;

    // Constructor
    public ShiftResponse(String original, String shifted) {
        this.original = original;
        this.shifted = shifted;
    }

    // Getters and setters
    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getShifted() {
        return shifted;
    }

    public void setShifted(String shifted) {
        this.shifted = shifted;
    }
}