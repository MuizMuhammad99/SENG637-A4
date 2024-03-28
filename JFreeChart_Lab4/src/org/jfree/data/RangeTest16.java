package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest16 {

	@Test
    public void testIsNaNRangeBothNaN() {
        Range range = new Range(Double.NaN, Double.NaN);
        assertTrue("Range with both bounds NaN should return true", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeLowerBoundNaN() {
        Range range = new Range(Double.NaN, 5.0);
        assertFalse("Range with only lower bound NaN should return false", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeUpperBoundNaN() {
        Range range = new Range(1.0, Double.NaN);
        assertFalse("Range with only upper bound NaN should return false", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeNoNaN() {
        Range range = new Range(1.0, 5.0);
        assertFalse("Range with no bounds NaN should return false", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeNegativeInfinity() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertFalse("Range with bounds as infinity should return false", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangePositiveInfinity() {
        Range range = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertFalse("Range with both bounds as positive infinity should return false", range.isNaNRange());
    }

    @Test
    public void testIsNaNRangeZeroBounds() {
        Range range = new Range(0.0, 0.0);
        assertFalse("Range with bounds as zero should return false", range.isNaNRange());
    }

}
