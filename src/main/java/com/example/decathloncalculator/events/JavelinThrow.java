package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class JavelinThrow implements Event {
    private static final double COEFFICIENT_A = 10.14;
    private static final double COEFFICIENT_B = 7;
    private static final double COEFFICIENT_C = 1.08;

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
        return 9;
    }

    public String getEventName() {
        return "Javelin Throw";
    }

    public String getEventUnits() {
        return "m";
    }
}
