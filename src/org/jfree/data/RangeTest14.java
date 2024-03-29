package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest14 {

	@Test
    public void testScaleUp() {
        Range base = new Range(2.0, 4.0);
        double factor = 2.0;
        Range expected = new Range(4.0, 8.0);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling up should double both bounds of the range", expected, result);
    }

    @Test
    public void testScaleDown() {
        Range base = new Range(2.0, 4.0);
        double factor = 0.5;
        Range expected = new Range(1.0, 2.0);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling down should halve both bounds of the range", expected, result);
    }

    @Test
    public void testScaleByZero() {
        Range base = new Range(1.0, 5.0);
        double factor = 0.0;
        Range expected = new Range(0.0, 0.0);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling by zero should result in a range from 0 to 0", expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testScaleByNegative() {
        Range base = new Range(1.0, 3.0);
        double factor = -1.0;
        Range.scale(base, factor);
    }

    @Test
    public void testScaleRangeIncludingZero() {
        Range base = new Range(-2.0, 2.0);
        double factor = 2.0;
        Range expected = new Range(-4.0, 4.0);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling a range that includes zero should work correctly", expected, result);
    }

    @Test
    public void testScaleVerySmallRange() {
        Range base = new Range(1E-5, 1E-4);
        double factor = 10.0;
        Range expected = new Range(1E-4, 1E-3);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling a very small range should work correctly", expected, result);
    }

    @Test
    public void testScaleVeryLargeRange() {
        Range base = new Range(1E5, 1E6);
        double factor = 0.1;
        Range expected = new Range(1E4, 1E5);
        Range result = Range.scale(base, factor);
        assertEquals("Scaling a very large range should work correctly", expected, result);
    }
    
    @Test
    public void testScaleWithInfinityFactor() {
        Range base = new Range(1.0, 5.0);
        double factor = Double.POSITIVE_INFINITY;
        Range result = Range.scale(base, factor);
        assertTrue("Scaling by infinity should result in infinite bounds", 
                   Double.isInfinite(result.getLowerBound()) && Double.isInfinite(result.getUpperBound()));
    }

    @Test
    public void testScaleInfiniteRange() {
        Range base = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        double factor = 2.0;
        Range result = Range.scale(base, factor);
        assertEquals("Scaling an infinite range should retain its infinity bounds", base, result);
    }

    @Test
    public void testScaleRangeIncludingNaN() {
        Range base = new Range(Double.NaN, 5.0);
        double factor = 2.0;
        Range result = Range.scale(base, factor);
        assertTrue("Scaling a range including NaN should result in NaN lower bound", 
                   Double.isNaN(result.getLowerBound()));
    }

    @Test
    public void testScaleByVerySmallFactor() {
        Range base = new Range(1.0, 100.0);
        double factor = Double.MIN_VALUE;
        Range result = Range.scale(base, factor);
        assertTrue("Scaling by a very small factor should result in lower bound close to 0", 
                   Math.abs(result.getLowerBound() - 0.0) < 1E-323);
        assertTrue("Upper bound should be greater than lower bound after scaling", 
                   result.getUpperBound() > result.getLowerBound());
    }

    @Test
    public void testScaleByVeryLargeFactor() {
        Range base = new Range(1.0, 5.0);
        double factor = Double.MAX_VALUE;
        Range result = Range.scale(base, factor);
        assertTrue("Scaling by a very large factor should result in a very large range", 
                   Double.isInfinite(result.getUpperBound()));
    }

    @Test
    public void testScaleZeroWidthRangeNotAtZero() {
        Range base = new Range(5.0, 5.0);
        double factor = 2.0;
        Range result = Range.scale(base, factor);
        assertTrue("Scaling a zero-width range should result in zero-width at scaled position", 
                   result.getLowerBound() == result.getUpperBound() && result.getLowerBound() != 0.0);
    }

}
