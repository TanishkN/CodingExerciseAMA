package com.tanishk.codingExercise;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.tanishk.codingExercise.dto.ShiftRequest;
import com.tanishk.codingExercise.service.ShiftService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

//Different test cases based on a shift
class CodingExerciseApplicationTests {

    private final ShiftService shiftService = new ShiftService();
    private static Validator validator;
    
    @Test
    void testThatValidInputAndPositiveShiftShouldWork() {
            // Given
            String input = "abcdef";
            int shift = 2;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals("efabcd", result);
    }
    @Test
    void testThatValidInputAndFullRotationShiftShouldWork() {
            // Given
            String input = "abcdef";
            int shift = 6;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals("abcdef", result);
    }
    @Test
    void testThatValidInputAndSpacesShiftShouldWork() {
            // Given
            String input = "hello wor   l  d";
            int shift = 8;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals("r   l  dhello wo", result);
    }
    @Test
    void testThatLargeShiftAmountShouldRotate() {
            // Given
            String input = "hello world";
            int shift = 94;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals(" worldhello", result);
    }
    //Edge Case
    @Test
    void testThatSingleCharacterShouldWork() {
            // Given
            String input = "a";
            int shift = 100;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals("a", result);
    }
    @Test
    void testThatLargeStringShouldWork() {
            // Given
            String input = "abcdefghijklmnopqrst";
            int shift = 99;
   
            // When
            String result = shiftService.shiftCharacters(input, shift);
   
            // Then
            assertEquals("bcdefghijklmnopqrsta", result);
    }

    @Test
    void testThatEmptyStringShouldNotWork() {
        // Given
        ShiftRequest request = new ShiftRequest("", 2);
        
        // When
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        // Then
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString()); // Check which field failed
        assertEquals("Input string cannot be empty.", violation.getMessage()); // Standard Jakarta message
        
    }
    @Test
    void testThatNegativeNumberShouldNotWork() {
        // Given
        ShiftRequest request = new ShiftRequest("hello world", -10);
   
        // When
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
   
        // Then
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("shift", violation.getPropertyPath().toString()); // Check which field failed
        assertEquals("Shift value must be non-negative.", violation.getMessage()); // Standard Jakarta message
    }

    @Test
    void testThatNullInputShouldNotWork() {
    // Given
        ShiftRequest request = new ShiftRequest(null, 5);
    
    // When
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
    
    // Then
        assertEquals(1, violations.size()); // Check exactly one violation exists
    
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString()); // Check which field failed
        assertEquals("Input string cannot be empty.", violation.getMessage()); // Standard Jakarta message
    // OR if you customized the message:
    // assertEquals("Input string cannot be empty", violation.getMessage());
    }   

}