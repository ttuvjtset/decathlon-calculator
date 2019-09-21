package com.example.decathloncalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventAndRawPerformance {
    @Min(value = 1, message = "Event sequence number must be at least 1")
    @Max(value = 10, message = "Event sequence number must be lower or equal to 10")
    @NotNull(message = "Event sequence number must be specified")
    private String event;

    @Min(value = 0, message = "Raw performance must be a positive number")
    @NotNull(message = "Raw performance must be specified")
    private String rawPerformance;
}
