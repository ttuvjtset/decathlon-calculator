package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.LongJump;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreLongJumpTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new LongJump();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testLongJump1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("7"));
        int scoreInt = score.intValue();
        assertEquals(814, scoreInt);
    }

    @Test
    public void testLongJump2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("8"));
        int scoreInt = score.intValue();
        assertEquals(1061, scoreInt);
    }

    @Test
    public void testLongJump3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("9"));
        int scoreInt = score.intValue();
        assertEquals(1325, scoreInt);
    }

    @Test
    public void testLongJumpZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
