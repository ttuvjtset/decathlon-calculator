package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.JavelinThrow;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreJavelinThrowTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new JavelinThrow();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testJavelinThrow1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("80"));
        int scoreInt = score.intValue();
        assertEquals(1043, scoreInt);
    }

    @Test
    public void testJavelinThrow2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("100"));
        int scoreInt = score.intValue();
        assertEquals(1355, scoreInt);
    }

    @Test
    public void testJavelinThrow3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("120"));
        int scoreInt = score.intValue();
        assertEquals(1672, scoreInt);
    }

    @Test
    public void testJavelinThrowZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
