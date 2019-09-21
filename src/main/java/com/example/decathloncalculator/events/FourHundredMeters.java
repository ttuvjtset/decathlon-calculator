package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class FourHundredMeters implements Event {
    private static final double COEFFICIENT_A = 1.53775;
    private static final double COEFFICIENT_B = 82d;
    private static final double COEFFICIENT_C = 1.81;

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
        return 5;
    }

    public String getEventName() {
        return "400 m";
    }

    public String getEventUnits() {
        return "sec";
    }
}
