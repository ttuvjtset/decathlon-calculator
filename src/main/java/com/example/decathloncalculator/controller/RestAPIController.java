package com.example.decathloncalculator.controller;

import com.example.decathloncalculator.model.EventAndRawPerformance;
import com.example.decathloncalculator.service.CalculateScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RestAPIController {
    private final CalculateScoreService calculateScoreService;

    @Autowired
    public RestAPIController(CalculateScoreService calculateScoreService) {
        this.calculateScoreService = calculateScoreService;
    }

    @PostMapping("/calculatePointsAPI")
    public Object home(@RequestBody @Valid EventAndRawPerformance eventAndRawPerformance) {

        return calculateScoreService.getAPIResponse(
                eventAndRawPerformance.getEvent(),
                eventAndRawPerformance.getRawPerformance()
        );

    }
}
