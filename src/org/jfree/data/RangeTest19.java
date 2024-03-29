package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RangeTest19 {

	private Range exampleRange;

    @Before
    public void setUp() {
        // Setup an example range for use in the tests
        exampleRange = new Range(-10.0, 10.0);
    }

    @Test
    public void testContains_NumberWithinRange() {
        assertTrue("Number within range", exampleRange.contains(0));
    }

    @Test
    public void testContains_NumberEqualToLowerBound() {
        assertTrue("Number equal to lower bound", exampleRange.contains(-10.0));
    }

    @Test
    public void testContains_NumberEqualToUpperBound() {
        assertTrue("Number equal to upper bound", exampleRange.contains(10.0));
    }

    @Test
    public void testContains_NumberBelowLowerBound() {
        assertFalse("Number below lower bound", exampleRange.contains(-11.0));
    }

    @Test
    public void testContains_NumberAboveUpperBound() {
        assertFalse("Number above upper bound", exampleRange.contains(11.0));
    }

    @Test
    public void testContains_LowerBoundEdgeCase() {
        // Testing very close to lower bound but not equal
        assertFalse("Lower bound edge case", exampleRange.contains(-10.0001));
    }

    @Test
    public void testContains_UpperBoundEdgeCase() {
        // Testing very close to upper bound but not equal
        assertFalse("Upper bound edge case", exampleRange.contains(10.0001));
    }

    @Test
    public void testContains_NegativeNumberWithinRange() {
        assertTrue("Negative number within range", exampleRange.contains(-5.0));
    }

    @Test
    public void testContains_PositiveNumberWithinRange() {
        assertTrue("Positive number within range", exampleRange.contains(5.0));
    }
    
    @Test
    public void testContains_ValueAtUpperBoundAfterIncrement() {
        Range range = new Range(5.0, 10.0);
        double value = 9.0;
        value++; // value is now 10.0, equivalent to post-increment in mutant
        assertTrue("Range should contain value after increment if it's within bounds", range.contains(value));
    }

    @Test
    public void testContains_ValueAtLowerBoundBeforeDecrement() {
        Range range = new Range(5.0, 10.0);
        double value = 6.0;
        value--; // value is now 5.0, equivalent to pre-decrement in mutant
        assertTrue("Range should contain value after decrement if it's within bounds", range.contains(value));
    }

    @Test
    public void testContains_SubstitutingOneWithNegativeOne() {
        Range range = new Range(1.0, 10.0);
        assertFalse("Range should not contain a negative value if the range is positive", range.contains(-1.0));
        assertFalse("Range should not contain a value outside of its bounds when upper is negated", range.contains(11.0));
    }
    
    @Test
    public void testContains_PositiveInfinityWithinRange() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertTrue("Positive infinity should be considered within an infinite range", range.contains(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testContains_NegativeInfinityWithinRange() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertTrue("Negative infinity should be considered within an infinite range", range.contains(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void testContains_NaN() {
        assertFalse("NaN should not be considered within any range", exampleRange.contains(Double.NaN));
    }

    @Test
    public void testContains_NumberCloseToZero() {
        // Assuming the range includes zero
        assertTrue("Numbers very close to zero should be considered within the range", exampleRange.contains(1E-100));
    }

    @Test
    public void testContains_ExtremePositiveNumber() {
        Range range = new Range(1.0, Double.MAX_VALUE);
        assertTrue("Extreme positive numbers within the range should be considered within", range.contains(Double.MAX_VALUE / 2));
    }

    @Test
    public void testContains_ExtremeNegativeNumber() {
        Range range = new Range(Double.MIN_VALUE, 100.0);
        assertTrue("Extreme negative numbers close to zero should be considered within", range.contains(Double.MIN_VALUE));
    }

    @Test
    public void testContains_LowerBoundPrecisionIssue() {
        Range range = new Range(1.0000001, 5.0);
        assertFalse("Number just below the lower bound due to precision should not be considered within", range.contains(1.0));
    }

    @Test
    public void testContains_UpperBoundPrecisionIssue() {
        Range range = new Range(1.0, 4.9999999);
        assertFalse("Number just above the upper bound due to precision should not be considered within", range.contains(5.0));
    }

    @Test
    public void testContains_WithPrecisionEdgeNearLowerBound() {
        Range range = new Range(1.0, 5.0);
        assertTrue("Number very close to the lower bound should be considered within the range", range.contains(1.00000000000001));
    }

    @Test
    public void testContains_WithPrecisionEdgeNearUpperBound() {
        Range range = new Range(1.0, 5.0);
        assertTrue("Number very close to the upper bound should be considered within the range", range.contains(4.99999999999999));
    }

}
