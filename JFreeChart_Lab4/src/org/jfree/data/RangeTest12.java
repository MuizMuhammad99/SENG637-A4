package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest12 {

	@Test
    public void testShiftPositiveValueWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(5.0, 3.0);
        assertEquals("Shifting a positive value with a positive delta should work correctly", 8.0, result, 0.0);
    }

    @Test
    public void testShiftNegativeValueWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(-5.0, -3.0);
        assertEquals("Shifting a negative value with a negative delta should work correctly", -8.0, result, 0.0);
    }

    @Test
    public void testShiftPositiveValueWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(5.0, -10.0);
        assertEquals("Shifting a positive value with a negative delta large enough to cross zero should clamp to zero", 0.0, result, 0.0);
    }

    @Test
    public void testShiftNegativeValueWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(-5.0, 10.0);
        assertEquals("Shifting a negative value with a positive delta large enough to cross zero should clamp to zero", 0.0, result, 0.0);
    }

    @Test
    public void testShiftValueAtZeroWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(0.0, 5.0);
        assertEquals("Shifting a value at zero with a positive delta should work correctly", 5.0, result, 0.0);
    }

    @Test
    public void testShiftValueAtZeroWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(0.0, -5.0);
        assertEquals("Shifting a value at zero with a negative delta should work correctly", -5.0, result, 0.0);
    }

    @Test
    public void testShiftVerySmallPositiveValueWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(1e-10, -1e-9);
        assertEquals("Shifting a very small positive value with a negative delta should clamp to zero", 0.0, result, 0.0);
    }

    @Test
    public void testShiftVerySmallNegativeValueWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(-1e-10, 1e-9);
        assertEquals("Shifting a very small negative value with a positive delta should clamp to zero", 0.0, result, 0.0);
    }
    
    @Test
    public void testShiftMaxValueWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(Double.MAX_VALUE, 1.0);
        assertEquals("Shifting MAX_VALUE with a positive delta should result in MAX_VALUE",
                     Double.MAX_VALUE, result, 0.0);
    }

    @Test
    public void testShiftMinValueWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(Double.MIN_VALUE, -1.0);
        assertEquals("Shifting MIN_VALUE with a negative delta should clamp to zero",
                     0.0, result, 0.0);
    }

    @Test
    public void testShiftWithNaNValue() {
        double result = Range.shiftWithNoZeroCrossing(Double.NaN, 1.0);
        assertTrue("Shifting NaN value should result in NaN", Double.isNaN(result));
    }

    @Test
    public void testShiftWithNaNDelta() {
        double result = Range.shiftWithNoZeroCrossing(1.0, Double.NaN);
        assertTrue("Shifting with NaN delta should result in NaN", Double.isNaN(result));
    }

    @Test
    public void testShiftInfinityWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(Double.POSITIVE_INFINITY, 1.0);
        assertEquals("Shifting positive infinity with any delta should remain infinity",
                     Double.POSITIVE_INFINITY, result, 0.0);
    }

    @Test
    public void testShiftNegativeInfinityWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(Double.NEGATIVE_INFINITY, -1.0);
        assertEquals("Shifting negative infinity with any delta should remain negative infinity",
                     Double.NEGATIVE_INFINITY, result, 0.0);
    }

    @Test
    public void testShiftPositiveValueToBecomeNegativeInfinityWithNegativeDelta() {
        double result = Range.shiftWithNoZeroCrossing(1.0, Double.NEGATIVE_INFINITY);
        assertEquals("Shifting a positive value with negative infinity delta should clamp to zero",
                     0.0, result, 0.0);
    }

    @Test
    public void testShiftNegativeValueToBecomePositiveInfinityWithPositiveDelta() {
        double result = Range.shiftWithNoZeroCrossing(-1.0, Double.POSITIVE_INFINITY);
        assertEquals("Shifting a negative value with positive infinity delta should clamp to zero",
                     0.0, result, 0.0);
    }

}
