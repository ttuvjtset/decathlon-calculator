package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.ShotPut;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreShotPutTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new ShotPut();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testShotPut1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("10"));
        int scoreInt = score.intValue();
        assertEquals(486, scoreInt);
    }

    @Test
    public void testShotPut2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("19"));
        int scoreInt = score.intValue();
        assertEquals(1037, scoreInt);
    }

    @Test
    public void testShotPut3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("25"));
        int scoreInt = score.intValue();
        assertEquals(1414, scoreInt);
    }

    @Test
    public void testShotPutZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
