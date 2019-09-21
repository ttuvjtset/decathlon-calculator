package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class DiscusThrow implements Event {
    private static final double COEFFICIENT_A = 12.91;
    private static final double COEFFICIENT_B = 4;
    private static final double COEFFICIENT_C = 1.1;

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
        return 7;
    }

    public String getEventName() {
        return "Discus Throw";
    }

    public String getEventUnits() {
        return "m";
    }
}
