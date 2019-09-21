package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class HighJump implements Event {
    private static final double COEFFICIENT_A = 585.64;
    private static final double COEFFICIENT_B = 0.75;
    private static final double COEFFICIENT_C = 1.42;

    public double getCoefficientA() {
        return COEFFICIENT_A;
    }

    public double getCoefficientB() {
        return COEFFICIENT_B;
    }

    public double getCoefficientC() {
        return COEFFICIENT_C;
    }

    public int getSeqNumber() {
        return 4;
    }

    public String getEventName() {
        return "High jump";
    }

    public String getEventUnits() {
        return "m";
    }
}

