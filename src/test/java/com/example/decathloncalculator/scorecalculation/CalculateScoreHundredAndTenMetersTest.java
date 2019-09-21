package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.HundredAndTenMeters;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreHundredAndTenMetersTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new HundredAndTenMeters();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testHundredAndTenMeters1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("5"));
        int scoreInt = score.intValue();
        assertEquals(2463, scoreInt);
    }

    @Test
    public void testHundredAndTenMeters2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("10"));
        int scoreInt = score.intValue();
        assertEquals(1556, scoreInt);
    }

    @Test
    public void testHundredAndTenMeters3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("15"));
        int scoreInt = score.intValue();
        assertEquals(850, scoreInt);
    }

    @Test
    public void testHundredAndTenMetersZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }

}
