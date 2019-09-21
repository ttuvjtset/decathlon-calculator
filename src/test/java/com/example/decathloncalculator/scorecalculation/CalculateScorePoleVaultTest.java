package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.PoleVault;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScorePoleVaultTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new PoleVault();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testPoleVault1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("5"));
        int scoreInt = score.intValue();
        assertEquals(910, scoreInt);
    }

    @Test
    public void testPoleVault2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("6"));
        int scoreInt = score.intValue();
        assertEquals(1231, scoreInt);
    }

    @Test
    public void testPoleVault3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("7"));
        int scoreInt = score.intValue();
        assertEquals(1574, scoreInt);
    }

    @Test
    public void testPoleVaultZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
