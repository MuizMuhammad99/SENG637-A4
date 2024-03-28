package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest5 {

	@Test
    public void testBothRangesNull() {
        assertNull("Combining two null ranges should return null", 
            Range.combineIgnoringNaN(null, null));
    }

    @Test
    public void testFirstRangeNullSecondRangeValid() {
        Range range2 = new Range(1.0, 5.0);
        Range result = Range.combineIgnoringNaN(null, range2);
        assertNotNull("Result should not be null when second range is valid", result);
        assertEquals("Result should be equal to the second range", range2, result);
    }

    @Test
    public void testFirstRangeValidSecondRangeNull() {
        Range range1 = new Range(2.0, 6.0);
        Range result = Range.combineIgnoringNaN(range1, null);
        assertNotNull("Result should not be null when first range is valid", result);
        assertEquals("Result should be equal to the first range", range1, result);
    }

    @Test
    public void testBothRangesValid() {
        Range range1 = new Range(1.0, 3.0);
        Range range2 = new Range(2.0, 4.0);
        Range expected = new Range(1.0, 4.0);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Combining two valid ranges should return the correct range", expected, result);
    }

    @Test
    public void testFirstRangeContainsNaNSecondRangeValid() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(1.0, 5.0);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals("Second valid range should be returned when first range contains NaN", range2, result);
    }

    @Test
    public void testFirstRangeValidSecondRangeContainsNaN() {
        Range range1 = new Range(2.0, 6.0);
        Range range2 = new Range(Double.NaN, Double.NaN);
        Range result = Range.combineIgnoringNaN(range1, range2);
        assertEquals("First valid range should be returned when second range contains NaN", range1, result);
    }

    @Test
    public void testBothRangesContainNaN() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(Double.NaN, Double.NaN);
        assertNull("Combining two ranges that both contain NaN should return null", 
            Range.combineIgnoringNaN(range1, range2));
    }
    
    @Test
    public void testCombineIgnoringNaN_EqualToGreaterOrEqual() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(5.0, 10.0); // Tests boundary where ranges touch or overlap
        Range combined = Range.combineIgnoringNaN(range1, range2);
        assertNotNull("Combined range should not be null", combined);
        assertEquals("Lower bound should match range1's lower", 1.0, combined.getLowerBound(), 0.0);
        assertEquals("Upper bound should match range2's upper", 10.0, combined.getUpperBound(), 0.0);
    }

    @Test
    public void testCombineIgnoringNaN_EqualToLessOrEqual() {
        Range range1 = new Range(-10.0, -5.0);
        Range range2 = new Range(-5.0, 0.0); // Tests boundary where ranges touch or overlap
        Range combined = Range.combineIgnoringNaN(range1, range2);
        assertNotNull("Combined range should not be null", combined);
        assertEquals("Lower bound should match range1's lower", -10.0, combined.getLowerBound(), 0.0);
        assertEquals("Upper bound should match range2's upper", 0.0, combined.getUpperBound(), 0.0);
    }

    // This test conceptually represents the scenario where equality checks within combineIgnoringNaN are always false
    @Test
    public void testCombineIgnoringNaN_WithAlwaysFalseCondition() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(Double.NaN, Double.NaN);
        // Simulating "false" by using ranges that would typically result in null if combined normally
        Range combined = Range.combineIgnoringNaN(range1, range2);
        assertNull("Combined range should be null when both are NaN", combined);
    }

    // Negating double local variable scenarios
    @Test
    public void testCombineIgnoringNaN_NegatedDoubleLocalVariable() {
        Range range1 = new Range(-Double.NaN, 5.0); // Negating NaN has no effect, still NaN
        Range range2 = new Range(5.0, 10.0);
        Range combined = Range.combineIgnoringNaN(range1, range2);
        assertNotNull("Combined range should not be null despite negated NaN", combined);
        assertEquals("Lower bound should be range2's lower due to negated NaN in range1", 5.0, combined.getLowerBound(), 0.0);
        assertEquals("Upper bound should be range2's upper", 10.0, combined.getUpperBound(), 0.0);
    }

    // This test conceptually represents the scenario where equality checks within combineIgnoringNaN are always true
    @Test
    public void testCombineIgnoringNaN_WithAlwaysTrueCondition() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(5.0, 10.0);
        // Assuming an internal condition is always true, this setup is to demonstrate normal operation
        Range combined = Range.combineIgnoringNaN(range1, range2);
        assertNotNull("Combined range should not be null under normal conditions", combined);
        assertEquals("Lower bound should match the smallest lower bound of both ranges", 1.0, combined.getLowerBound(), 0.0);
        assertEquals("Upper bound should match the largest upper bound of both ranges", 10.0, combined.getUpperBound(), 0.0);
    }

}
