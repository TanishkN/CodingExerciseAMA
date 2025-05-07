package com.tanishk.codingExercise;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tanishk.codingExercise.dto.ShiftRequest;
import com.tanishk.codingExercise.service.ShiftService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

//Different test cases based on a shift
class CodingExerciseApplicationTests {

    private final ShiftService shiftService = new ShiftService();
    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    
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
        ShiftRequest request = new ShiftRequest("", 2);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertFalse(violations.isEmpty(), "Should have violations for empty string");
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString());
        assertEquals("Input string must be more than 1 character or less than 20 characters.", violation.getMessage());
    }

    @Test
    void testThatNegativeNumberShouldNotWork() {
        ShiftRequest request = new ShiftRequest("hello world", -10);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("shift", violation.getPropertyPath().toString());
        assertEquals("Shift value must be non-negative.", violation.getMessage());
    }

    @Test
    void testThatNullInputShouldNotWork() {
        ShiftRequest request = new ShiftRequest(null, 5);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString());
        assertEquals("Input string cannot be empty.", violation.getMessage());
    }

    @Test
    void testThatSpecialCharactersForInputShouldNotWork() {
        ShiftRequest request = new ShiftRequest("some!Value$used", 5);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString());
        assertEquals("Input string must contain only alphabetic characters and spaces.", violation.getMessage());
    }
    @Test
    void testThatInputExceedsLimitWhichShouldNotWork() {
        ShiftRequest request = new ShiftRequest("someerrfrvffhfjdpskfmi", 5);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("input", violation.getPropertyPath().toString());
        assertEquals("Input string must be more than 1 character or less than 20 characters.", violation.getMessage());
    }
    @Test
    void testThatShiftExceedsLimitWhichShouldNotWork() {
        ShiftRequest request = new ShiftRequest("some", 101);
        Set<ConstraintViolation<ShiftRequest>> violations = validator.validate(request);
        
        assertEquals(1, violations.size());
        ConstraintViolation<ShiftRequest> violation = violations.iterator().next();
        assertEquals("shift", violation.getPropertyPath().toString());
        assertEquals("Shift value must be less than or equal to 100.", violation.getMessage());
    }

}