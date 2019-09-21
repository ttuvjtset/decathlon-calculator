package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.DiscusThrow;
import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreDiscusThrowTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new DiscusThrow();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testDiscusThrow1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("50"));
        int scoreInt = score.intValue();
        assertEquals(870, scoreInt);
    }

    @Test
    public void testDiscusThrow2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("75"));
        int scoreInt = score.intValue();
        assertEquals(1403, scoreInt);
    }

    @Test
    public void testDiscusThrow3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("100"));
        int scoreInt = score.intValue();
        assertEquals(1956, scoreInt);
    }

    @Test
    public void testDiscusThrowZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
