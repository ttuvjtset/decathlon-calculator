package com.example.decathloncalculator.controller;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.model.EventAndRawPerformance;
import com.example.decathloncalculator.service.CalculateScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private final CalculateScoreService calculateScoreService;

    private final List<Event> events;

    @Autowired
    public WebController(List<Event> events, CalculateScoreService calculateScoreService) {
        this.events = events;
        this.calculateScoreService = calculateScoreService;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();

        List<Event> sortedEvents = events.stream()
                .sorted(Comparator.comparingInt(Event::getSeqNumber))
                .collect(Collectors.toList());

        modelAndView.addObject("events", sortedEvents);
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping("/calculate")
    public ModelAndView calculatePoints(@ModelAttribute("eventAndRawPerformance") @Valid
                                                    EventAndRawPerformance eventAndRawPerformance,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return home();
        } else {
            return calculateScoreService.getModelAndView(
                    eventAndRawPerformance.getEvent(),
                    eventAndRawPerformance.getRawPerformance()
            );
        }
    }

}
