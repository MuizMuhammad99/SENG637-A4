package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest13 {

	@Test
    public void testValueWithinRange() {
        Range range = new Range(1.0, 10.0);
        double value = 5.0;
        assertEquals("Value within range should be returned as is", 5.0, range.constrain(value), 0.0);
    }

    @Test
    public void testValueBelowRange() {
        Range range = new Range(1.0, 10.0);
        double value = -5.0;
        assertEquals("Value below range should return the lower bound", 1.0, range.constrain(value), 0.0);
    }

    @Test
    public void testValueAboveRange() {
        Range range = new Range(1.0, 10.0);
        double value = 15.0;
        assertEquals("Value above range should return the upper bound", 10.0, range.constrain(value), 0.0);
    }

    @Test
    public void testValueExactlyAtLowerBound() {
        Range range = new Range(1.0, 10.0);
        double value = 1.0;
        assertEquals("Value at the lower bound should be returned as is", 1.0, range.constrain(value), 0.0);
    }

    @Test
    public void testValueExactlyAtUpperBound() {
        Range range = new Range(1.0, 10.0);
        double value = 10.0;
        assertEquals("Value at the upper bound should be returned as is", 10.0, range.constrain(value), 0.0);
    }

    @Test
    public void testNegativeRangeValueWithinRange() {
        Range range = new Range(-10.0, -1.0);
        double value = -5.0;
        assertEquals("Value within a negative range should be returned as is", -5.0, range.constrain(value), 0.0);
    }

    @Test
    public void testNegativeRangeValueBelowRange() {
        Range range = new Range(-10.0, -1.0);
        double value = -15.0;
        assertEquals("Value below a negative range should return the lower bound", -10.0, range.constrain(value), 0.0);
    }

    @Test
    public void testNegativeRangeValueAboveRange() {
        Range range = new Range(-10.0, -1.0);
        double value = 0.0;
        assertEquals("Value above a negative range should return the upper bound", -1.0, range.constrain(value), 0.0);
    }

    @Test
    public void testZeroInRange() {
        Range range = new Range(-10.0, 10.0);
        double value = 0.0;
        assertEquals("Zero within range should be returned as is", 0.0, range.constrain(value), 0.0);
    }
    
    @Test
    public void testConstrain_IncrementPre() {
        Range range = new Range(5.0, 10.0);
        // Simulate pre-increment on the input
        double value = 9.0;
        double result = range.constrain(++value); // real pre-increment effect
        assertEquals("Pre-increment value should be within the range", 10.0, result, 0.0);
    }

    @Test
    public void testConstrain_NotGreaterThan() {
        Range range = new Range(5.0, 10.0);
        // Test value exactly at the upper bound
        double result = range.constrain(10.0);
        assertEquals("Value equal to upper bound should be within the range", 10.0, result, 0.0);
    }

    @Test
    public void testConstrain_NotLessThan() {
        Range range = new Range(5.0, 10.0);
        // Test value exactly at the lower bound
        double result = range.constrain(5.0);
        assertEquals("Value equal to lower bound should be within the range", 5.0, result, 0.0);
    }

    @Test
    public void testConstrain_LessOrEqualToLessThan() {
        Range range = new Range(5.0, 10.0);
        // Value less than lower bound
        double result = range.constrain(4.9);
        assertEquals("Value less than lower bound should be constrained to lower bound", 5.0, result, 0.0);
    }

    @Test
    public void testConstrain_GreaterOrEqualToEqual() {
        Range range = new Range(5.0, 10.0);
        // Value exactly at the lower bound, testing for equality
        double result = range.constrain(5.0);
        assertEquals("Value equal to lower bound should be considered within the range", 5.0, result, 0.0);
    }

    @Test
    public void testConstrain_GreaterOrEqualToGreaterThan() {
        Range range = new Range(5.0, 10.0);
        // Value greater than upper bound
        double result = range.constrain(10.1);
        assertEquals("Value greater than upper bound should be constrained to upper bound", 10.0, result, 0.0);
    }
    
    @Test
    public void testConstrainWithPositiveInfinity() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(Double.POSITIVE_INFINITY);
        assertEquals("Constraining positive infinity should return the upper bound",
                     10.0, result, 0.0);
    }

    @Test
    public void testConstrainWithNegativeInfinity() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(Double.NEGATIVE_INFINITY);
        assertEquals("Constraining negative infinity should return the lower bound",
                     1.0, result, 0.0);
    }

    @Test
    public void testConstrainWithNaN() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(Double.NaN);
        assertTrue("Constraining NaN should result in NaN",
                   Double.isNaN(result));
    }

    @Test
    public void testConstrainUpperBoundWithPrecisionIssue() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(10.000000000000002); // Slightly above the upper bound due to precision
        assertEquals("Constraining a value slightly above the upper bound should return the upper bound",
                     10.0, result, 0.0);
    }

    @Test
    public void testConstrainLowerBoundWithPrecisionIssue() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(0.999999999999998); // Slightly below the lower bound due to precision
        assertEquals("Constraining a value slightly below the lower bound should return the lower bound",
                     1.0, result, 0.0);
    }

    @Test
    public void testConstrainJustAboveUpperBound() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(10.0000000001); // Just slightly above the upper bound
        assertEquals("Value just above the upper bound should be constrained to the upper bound",
                     10.0, result, 0.0);
    }

    @Test
    public void testConstrainJustBelowLowerBound() {
        Range range = new Range(1.0, 10.0);
        double result = range.constrain(0.9999999999); // Just slightly below the lower bound
        assertEquals("Value just below the lower bound should be constrained to the lower bound",
                     1.0, result, 0.0);
    }

}
