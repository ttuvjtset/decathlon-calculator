package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class ShotPut implements Event {
    private static final double COEFFICIENT_A = 51.39;
    private static final double COEFFICIENT_B = 1.5;
    private static final double COEFFICIENT_C = 1.05;

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
        return 3;
    }

    public String getEventName() {
        return "Shot put";
    }

    public String getEventUnits() {
        return "m";
    }
}
