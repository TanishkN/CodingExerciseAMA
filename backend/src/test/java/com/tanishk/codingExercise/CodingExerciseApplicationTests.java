package com.tanishk.codingExercise;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.tanishk.codingExercise.service.ShiftService;
//Different test cases based on a shift 
class CodingExerciseApplicationTests {

    private final ShiftService shiftService = new ShiftService();

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
            assertEquals("r   l  dhello wo ", result);
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
            String input = "abcdefghijklmnopqrstu";
            int shift = 99;
    
            // When
            String result = shiftService.shiftCharacters(input, shift);
    
            // Then
            assertEquals("efabcd", result);
    }

    @Test
    void testThatEmptyInputShouldReturnError() {
            // Given
            String input = "";
            int shift = 2;
    
            // When
            String result = shiftService.shiftCharacters(input, shift);
    
            // Then
            assertEquals("efabcd", result);
    }
    @Test
    void testThatInvalidShiftShouldThrowException() {
            // Given
            String input = "abcdef";
            int invalidShift = -10;
    
            // When
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shiftService.shiftCharacters(input, invalidShift), "Should throw error for invalid shift values");
            
            //Then
            assertEquals("Invalid shift value", exception.getMessage());
    }
    @Test
    void testThatNegativeInputShouldReturnError() {
            // Given
            String input = "abcdef";
            int invalidShift = -10;
    
            // When
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> shiftService.shiftCharacters(input, invalidShift), "Should throw error for invalid shift values");
            
            //Then
            assertEquals("Invalid shift value", exception.getMessage());
    }
}