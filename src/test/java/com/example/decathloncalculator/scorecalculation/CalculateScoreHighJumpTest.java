package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.HighJump;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreHighJumpTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new HighJump();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testHighJump1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("5"));
        int scoreInt = score.intValue();
        assertEquals(4570, scoreInt);
    }

    @Test
    public void testHighJump2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("3"));
        int scoreInt = score.intValue();
        assertEquals(1852, scoreInt);
    }

    @Test
    public void testHighJump3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("2"));
        int scoreInt = score.intValue();
        assertEquals(803, scoreInt);
    }

    @Test
    public void testHighJumpZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }

}
