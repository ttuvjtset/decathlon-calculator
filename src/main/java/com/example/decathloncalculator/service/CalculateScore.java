package com.example.decathloncalculator.service;

import com.example.decathloncalculator.events.Event;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculateScore {
    private Event event;

    public double calculateScore(double rawPerformance) {
        if (areRawPointsZero(rawPerformance)) {
            return 0d;
        } else {

            return event.getCoefficientA() *
                    Math.pow(Math.abs(rawPerformance - event.getCoefficientB()), event.getCoefficientC());

        }
    }

    private boolean areRawPointsZero(double rawPerformance) {
        return rawPerformance == 0d;
    }
}
