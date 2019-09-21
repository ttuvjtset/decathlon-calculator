package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.HundredMeters;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreHundredMetersTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new HundredMeters();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testHundredMeters1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("5"));
        int scoreInt = score.intValue();
        assertEquals(2640, scoreInt);
    }

    @Test
    public void testHundredMeters2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("10"));
        int scoreInt = score.intValue();
        assertEquals(1096, scoreInt);
    }

    @Test
    public void testHundredMeters3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("15"));
        int scoreInt = score.intValue();
        assertEquals(185, scoreInt);
    }

    @Test
    public void testHundredMetersZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }

}