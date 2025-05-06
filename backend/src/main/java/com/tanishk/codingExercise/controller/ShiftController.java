package com.tanishk.codingExercise.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanishk.codingExercise.dto.ShiftRequest;
import com.tanishk.codingExercise.dto.ShiftResponse;
import com.tanishk.codingExercise.service.ShiftService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ShiftController {

    private static final Logger logger = LoggerFactory.getLogger(ShiftController.class);
    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping("/shift")
    public ShiftResponse shiftCharacters(@Valid @RequestBody ShiftRequest request) {
        logger.info("Received shift request: {}", request); // Logs the full DTO
        String shifted = shiftService.shiftCharacters(request.getInput(), request.getShift());
        return new ShiftResponse(request.getInput(), shifted); // Return a structured response
    }
}