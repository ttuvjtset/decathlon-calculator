package com.example.decathloncalculator.scorecalculation;

import com.example.decathloncalculator.events.Event;
import com.example.decathloncalculator.events.ThousandFiveHundredMeters;
import com.example.decathloncalculator.service.CalculateScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests based on http://www.oocities.org/mdetting/sports/decathlon.html
 */
public class CalculateScoreThousandFiveHundredMetersTest {
    private CalculateScore calculateScore;

    @Before
    public void setUp() throws Exception {
        Event event = new ThousandFiveHundredMeters();
        calculateScore = new CalculateScore(event);
    }

    @Test
    public void testThousandFiveHundredMeters1() {
        Double score = calculateScore.calculateScore(Double.parseDouble("200"));
        int scoreInt = score.intValue();
        assertEquals(1268, scoreInt);
    }

    @Test
    public void testThousandFiveHundredMeters2() {
        Double score = calculateScore.calculateScore(Double.parseDouble("220"));
        int scoreInt = score.intValue();
        assertEquals(1106, scoreInt);
    }

    @Test
    public void testThousandFiveHundredMeters3() {
        Double score = calculateScore.calculateScore(Double.parseDouble("240"));
        int scoreInt = score.intValue();
        assertEquals(953, scoreInt);
    }

    @Test
    public void testThousandFiveHundredMetersZero() {
        Double score = calculateScore.calculateScore(Double.parseDouble("0"));
        int scoreInt = score.intValue();
        assertEquals(0, scoreInt);
    }
}
