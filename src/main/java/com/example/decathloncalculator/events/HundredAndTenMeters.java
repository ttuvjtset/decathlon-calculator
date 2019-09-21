package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class HundredAndTenMeters implements Event {
    private static final double COEFFICIENT_A = 5.74354;
    private static final double COEFFICIENT_B = 28.5;
    private static final double COEFFICIENT_C = 1.92;

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
        return 6;
    }

    public String getEventName() {
        return "110 m";
    }

    public String getEventUnits() {
        return "sec";
    }
}
