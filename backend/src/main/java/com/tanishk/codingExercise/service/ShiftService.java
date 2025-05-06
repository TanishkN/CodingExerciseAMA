// filepath: src/main/java/com/tanishk/codingExercise/ShiftService.java
package com.tanishk.codingExercise.service;

import org.springframework.stereotype.Service;

@Service
public class ShiftService {
    /**
     * Shifts the characters in the input string by the specified number of positions.
     * @param input The input string to be shifted.
     * @param shift The number of positions to shift the characters.
     * @return The shifted string.
     */
    public String shiftCharacters(String input, int shift) {

        int length = input.length();
        int normalizedShift = shift % length;
        //String shiftedString = input.substring(normalizedShift)+ input.substring(0, normalizedShift);
        //return shiftedString;
        return input.substring(length - normalizedShift) +
               input.substring(0, length - normalizedShift);
    }
}
