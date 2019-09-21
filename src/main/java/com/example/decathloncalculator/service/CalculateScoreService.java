package com.example.decathloncalculator.service;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.model.Points;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class CalculateScoreService {
    private final List<Event> events;
    private final Points points;

    @Autowired
    public CalculateScoreService(List<Event> events, Points points) {
        this.events = events;
        this.points = points;
    }

    public Points getAPIResponse(String eventInput, String rawPerformanceInput) {

        Optional<Event> optEvent = convertEventInputIntoDecathlonClass(eventInput);

        if (bothInputsProvided(rawPerformanceInput, optEvent)) {
            Event event = optEvent.get();
            CalculateScore calculateScore = new CalculateScore(event);

            try {
                Double score = calculateScore.calculateScore(Double.parseDouble(rawPerformanceInput));
                int scoreInt = score.intValue();
                points.setPoints(scoreInt);
            } catch (NumberFormatException e) {
                System.out.println("Raw input is not a number");
            }
        }

        return points;
    }

    public ModelAndView getModelAndView(String eventInput, String rawPerformanceInput) {

        Points apiResponse = getAPIResponse(eventInput, rawPerformanceInput);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", apiResponse.getPoints());
        modelAndView.setViewName("calculatedPoints");

        return modelAndView;
    }

    private boolean bothInputsProvided(String rawPerformanceInput, Optional<Event> optEvent) {
        return checkIfEventProvided(optEvent) && checkIfRawPerformanceInputProvided(rawPerformanceInput);
    }

    private boolean checkIfEventProvided(Optional<Event> optEvent) {
        return optEvent.isPresent();
    }

    private boolean checkIfRawPerformanceInputProvided(String rawPerformanceInput) {
        return rawPerformanceInput != null && rawPerformanceInput.length() > 0;
    }

    private Optional<Event> convertEventInputIntoDecathlonClass(String eventInput) {
        return events.stream()
                .filter(e -> String.valueOf(e.getSeqNumber()).equals(eventInput))
                .findFirst();
    }
}
