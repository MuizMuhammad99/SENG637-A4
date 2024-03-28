package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest8 {

	@Test
    public void testExpandToIncludeWithNullRange() {
        Range result = Range.expandToInclude(null, 5.0);
        assertNotNull("Resulting range should not be null", result);
        assertEquals("New range lower bound should match the value", 5.0, result.getLowerBound(), 0.0);
        assertEquals("New range upper bound should match the value", 5.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueInsideRange() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, 5.0);
        assertEquals("Range should not change if value is inside", existingRange, result);
    }

    @Test
    public void testExpandToIncludeWithValueBelowRange() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, -5.0);
        assertEquals("New range lower bound should match the new value", -5.0, result.getLowerBound(), 0.0);
        assertEquals("New range upper bound should remain unchanged", 10.0, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueAboveRange() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, 15.0);
        assertEquals("New range upper bound should match the new value", 15.0, result.getUpperBound(), 0.0);
        assertEquals("New range lower bound should remain unchanged", 1.0, result.getLowerBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithValueAtLowerBound() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, 1.0);
        assertEquals("Range should not change if value is at the lower bound", existingRange, result);
    }

    @Test
    public void testExpandToIncludeWithValueAtUpperBound() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, 10.0);
        assertEquals("Range should not change if value is at the upper bound", existingRange, result);
    }
    
    @Test
    public void testExpandToIncludeWithNaNValue() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, Double.NaN);
        assertTrue("Including NaN should result in an unchanged range", existingRange.equals(result));
    }

    @Test
    public void testExpandToIncludeWithPositiveInfinity() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, Double.POSITIVE_INFINITY);
        assertEquals("Range should include positive infinity as upper bound", Double.POSITIVE_INFINITY, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithNegativeInfinity() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, Double.NEGATIVE_INFINITY);
        assertEquals("Range should include negative infinity as lower bound", Double.NEGATIVE_INFINITY, result.getLowerBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithMaxDoubleValue() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, Double.MAX_VALUE);
        assertEquals("Range should include Max double value as upper bound", Double.MAX_VALUE, result.getUpperBound(), 0.0);
    }

    @Test
    public void testExpandToIncludeWithMinDoubleValue() {
        Range existingRange = new Range(1.0, 10.0);
        Range result = Range.expandToInclude(existingRange, Double.MIN_VALUE);
        assertTrue("Range should include Min double value as lower bound",
                result.getLowerBound() == Double.MIN_VALUE);
    }

    @Test
    public void testExpandToIncludeWithEmptyRange() {
        Range existingRange = new Range(0.0, 0.0);
        Range result = Range.expandToInclude(existingRange, 5.0);
        assertEquals("Range lower bound should remain 0", 0.0, result.getLowerBound(), 0.0);
        assertEquals("Range upper bound should be updated to include new value", 5.0, result.getUpperBound(), 0.0);
    }

}
