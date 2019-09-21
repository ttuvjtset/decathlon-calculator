package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class HundredMeters implements Event {
    private static final double COEFFICIENT_A = 25.4348;
    private static final double COEFFICIENT_B = 18d;
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
        return 1;
    }

    public String getEventName() {
        return "100 m";
    }

    public String getEventUnits() {
        return "sec";
    }
}
