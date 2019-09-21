package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.FourHundredMeters;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreFourHundredMetersTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new FourHundredMeters();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testFourHundredMeters1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("15"));
        int scoreInt = score.intValue();
        assertEquals(3105, scoreInt);
    }

    @Test
    public void testFourHundredMeters2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("20"));
        int scoreInt = score.intValue();
        assertEquals(2698, scoreInt);
    }

    @Test
    public void testFourHundredMeters3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("25"));
        int scoreInt = score.intValue();
        assertEquals(2317, scoreInt);
    }

    @Test
    public void testFourHundredMetersZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
