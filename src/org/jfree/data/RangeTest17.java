package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest17 {

	@Test
    public void testReflexivity() {
        Range range = new Range(1.0, 5.0);
        assertTrue("An object should be equal to itself", range.equals(range));
    }

    @Test
    public void testSymmetry() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        assertTrue("Symmetry should hold for equals", range1.equals(range2) && range2.equals(range1));
    }

    @Test
    public void testTransitivity() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        Range range3 = new Range(1.0, 5.0);
        assertTrue("Transitivity should hold for equals", range1.equals(range2) && range2.equals(range3) && range1.equals(range3));
    }

    @Test
    public void testConsistency() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        Range range3 = new Range(2.0, 6.0);
        assertTrue("Consistency should hold for equals", range1.equals(range2));
        assertFalse("Consistency should hold for non-equals", range1.equals(range3));
    }

    @Test
    public void testNullReference() {
        Range range = new Range(1.0, 5.0);
        assertFalse("Should return false for null reference", range.equals(null));
    }

    @Test
    public void testDifferentClass() {
        Range range = new Range(1.0, 5.0);
        Object obj = new Object();
        assertFalse("Should return false when objects are of different classes", range.equals(obj));
    }

    @Test
    public void testDifferentLowerBound() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(2.0, 5.0);
        assertFalse("Should return false when lower bounds are different", range1.equals(range2));
    }

    @Test
    public void testDifferentUpperBound() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 6.0);
        assertFalse("Should return false when upper bounds are different", range1.equals(range2));
    }

    @Test
    public void testWithNaNValues() {
        Range range1 = new Range(Double.NaN, Double.NaN);
        Range range2 = new Range(Double.NaN, Double.NaN);
        assertTrue("Equals should handle NaN values correctly", range1.equals(range2));
    }
    
    @Test
    public void testRangesWithInfiniteBounds() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range range2 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertTrue("Ranges with infinite bounds should be considered equal", range1.equals(range2));
    }

    @Test
    public void testRangesIncludingZero() {
        Range range1 = new Range(-1.0, 0.0);
        Range range2 = new Range(-1.0, 0.0);
        assertTrue("Ranges including zero should be considered equal", range1.equals(range2));
    }

    @Test
    public void testRangesWithVerySmallNumbers() {
        Range range1 = new Range(1E-100, 1E-100);
        Range range2 = new Range(1E-100, 1E-100);
        assertTrue("Ranges with very small numbers should be considered equal", range1.equals(range2));
    }

    @Test
    public void testRangesWithVeryLargeNumbers() {
        Range range1 = new Range(1E100, 1E101);
        Range range2 = new Range(1E100, 1E101);
        assertTrue("Ranges with very large numbers should be considered equal", range1.equals(range2));
    }

}
