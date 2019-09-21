package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class LongJump implements Event {
    private static final double COEFFICIENT_A = 90.5674;
    private static final double COEFFICIENT_B = 2.2;
    private static final double COEFFICIENT_C = 1.4;

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
        return 2;
    }

    public String getEventName() {
        return "Long jump";
    }

    public String getEventUnits() {
        return "m";
    }
}
