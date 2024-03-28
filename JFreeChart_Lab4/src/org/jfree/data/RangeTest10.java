package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest10 {

	@Test
    public void testShiftPositive() {
        Range base = new Range(1.0, 5.0);
        double delta = 3.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a positive range by a positive delta should work correctly", new Range(4.0, 8.0), result);
    }

    @Test
    public void testShiftNegative() {
        Range base = new Range(1.0, 5.0);
        double delta = -2.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a range by a negative delta should work correctly", new Range(0.0, 3.0), result);
    }

    @Test
    public void testShiftByZero() {
        Range base = new Range(1.0, 5.0);
        double delta = 0.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a range by zero should leave the range unchanged", base, result);
    }

    @Test
    public void testShiftIncludesZero() {
        Range base = new Range(-5.0, 5.0);
        double delta = 10.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a range that includes zero should work correctly", new Range(0.0, 15.0), result);
    }

    @Test
    public void testShiftToCrossZeroPositive() {
        Range base = new Range(1.0, 5.0);
        double delta = -3.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a positive range to cross zero should work correctly", new Range(0.0, 2.0), result);
    }

    @Test
    public void testShiftToCrossZeroNegative() {
        Range base = new Range(-5.0, -1.0);
        double delta = 3.0;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a negative range to cross zero should work correctly", new Range(-2.0, 0.0), result);
    }

    @Test
    public void testShiftWithVeryLargeDelta() {
        Range base = new Range(1.0, 5.0);
        double delta = 1.0E10;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a range by a very large delta should work correctly", new Range(1.0E10 + 1.0, 1.0E10 + 5.0), result);
    }

    @Test
    public void testShiftWithVerySmallDelta() {
        Range base = new Range(1.0, 5.0);
        double delta = -1.0E-10;
        Range result = Range.shift(base, delta);
        assertEquals("Shifting a range by a very small delta should work correctly", new Range(1.0 - 1.0E-10, 5.0 - 1.0E-10), result);
    }
    
    @Test
    public void testShiftInfinityRange() {
        Range base = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        double delta = 100.0;
        Range result = Range.shift(base, delta);
        assertTrue("Shifting an infinite range should keep it infinite",
                   Double.isInfinite(result.getLowerBound()) && Double.isInfinite(result.getUpperBound()));
    }

    @Test
    public void testShiftNaNBound() {
        Range base = new Range(Double.NaN, 5.0);
        double delta = 10.0;
        Range result = Range.shift(base, delta);
        assertTrue("Shifting a range with NaN bound should result in NaN lower bound",
                   Double.isNaN(result.getLowerBound()));
    }

}
