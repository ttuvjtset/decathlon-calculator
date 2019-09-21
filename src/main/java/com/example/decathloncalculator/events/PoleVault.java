package com.example.decathloncalculator.events;

import org.springframework.stereotype.Component;

@Component
public class PoleVault implements Event {
    private static final double COEFFICIENT_A = 140.182;
    private static final double COEFFICIENT_B = 1;
    private static final double COEFFICIENT_C = 1.35;

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
        return 8;
    }

    public String getEventName() {
        return "Pole Vault";
    }

    public String getEventUnits() {
        return "m";
    }
}
