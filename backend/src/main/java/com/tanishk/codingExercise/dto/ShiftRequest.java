package com.tanishk.codingExercise.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ShiftRequest {
    @NotBlank(message = "Input string cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Input string must contain only alphabetic characters and spaces.")
    @Size(min = 1, max = 20, message = "Input string must be more than 1 character or less than 20 characters.")
    private String input;

    @Min(value = 0, message = "Shift value must be non-negative.")
    @Max(value = 100, message = "Shift value must be less than or equal to 100.")
    @NotNull(message = "Shift value cannot be null.")
    private Integer shift;

    // Constructor
    public ShiftRequest(String input, int shift) {
        this.input = input;
        this.shift = shift;
    }

    // Default constructor (required for deserialization)
    public ShiftRequest() {}
        // Getters and setters
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

}