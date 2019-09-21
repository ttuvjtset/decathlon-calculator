package com.example.decathloncalculator.events;

public interface Event {
    double getCoefficientA();

    double getCoefficientB();

    double getCoefficientC();

    int getSeqNumber();

    String getEventName();

    String getEventUnits();
}
