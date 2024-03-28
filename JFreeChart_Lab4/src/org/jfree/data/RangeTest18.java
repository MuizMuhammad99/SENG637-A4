package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest18 {

	@Test
    public void testCombine_BothRangesNull() {
        assertNull("Both ranges are null", Range.combine(null, null));
    }

    @Test
    public void testCombine_FirstRangeNull() {
        Range range2 = new Range(1.0, 5.0);
        Range result = Range.combine(null, range2);
        assertEquals("First range is null", range2, result);
    }

    @Test
    public void testCombine_SecondRangeNull() {
        Range range1 = new Range(2.0, 6.0);
        Range result = Range.combine(range1, null);
        assertEquals("Second range is null", range1, result);
    }

    @Test
    public void testCombine_NoOverlap() {
        Range range1 = new Range(1.0, 3.0);
        Range range2 = new Range(4.0, 6.0);
        Range expected = new Range(1.0, 6.0);
        Range result = Range.combine(range1, range2);
        assertEquals("Ranges do not overlap", expected, result);
    }

    @Test
    public void testCombine_Overlap() {
        Range range1 = new Range(2.0, 5.0);
        Range range2 = new Range(3.0, 7.0);
        Range expected = new Range(2.0, 7.0);
        Range result = Range.combine(range1, range2);
        assertEquals("Ranges overlap", expected, result);
    }

    @Test
    public void testCombine_SameRanges() {
        Range range1 = new Range(2.0, 5.0);
        Range expected = new Range(2.0, 5.0);
        Range result = Range.combine(range1, range1);
        assertEquals("Same ranges", expected, result);
    }

    @Test
    public void testCombine_ContainedWithinEachOther() {
        Range range1 = new Range(1.0, 10.0);
        Range range2 = new Range(2.0, 8.0);
        Range expected = new Range(1.0, 10.0);
        Range result = Range.combine(range1, range2);
        assertEquals("One range is contained within the other", expected, result);
    }
    
    @Test
    public void testCombine_NegativeValues() {
        Range range1 = new Range(-5.0, -1.0);
        Range range2 = new Range(-10.0, -6.0);
        Range expected = new Range(-10.0, -1.0);
        Range result = Range.combine(range1, range2);
        assertEquals("Ranges with negative values", expected, result);
    }
    
    @Test
    public void testCombine_ZeroWidthRanges() {
        Range range1 = new Range(5.0, 5.0);
        Range range2 = new Range(7.0, 7.0);
        Range expected = new Range(5.0, 7.0);
        Range result = Range.combine(range1, range2);
        assertEquals("Combining zero-width ranges", expected, result);
    }

    @Test
    public void testCombine_WithPositiveInfinity() {
        Range range1 = new Range(1.0, Double.POSITIVE_INFINITY);
        Range range2 = new Range(2.0, 6.0);
        Range expected = new Range(1.0, Double.POSITIVE_INFINITY);
        Range result = Range.combine(range1, range2);
        assertEquals("Combining a range with positive infinity", expected, result);
    }

    @Test
    public void testCombine_WithNegativeInfinity() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, -1.0);
        Range range2 = new Range(-2.0, -1.5);
        Range expected = new Range(Double.NEGATIVE_INFINITY, -1.0);
        Range result = Range.combine(range1, range2);
        assertEquals("Combining a range with negative infinity", expected, result);
    }

//    @Test
//    public void testCombine_WithNaNValues() {
//        Range range1 = new Range(Double.NaN, 10.0);
//        Range range2 = new Range(5.0, Double.NaN);
//        assertNull("Combining ranges with NaN should return null", Range.combine(range1, range2));
//    }

    @Test
    public void testCombine_InfiniteRanges() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range range2 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range expected = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range result = Range.combine(range1, range2);
        assertEquals("Combining infinite ranges", expected, result);
    }

    @Test
    public void testCombine_RangesWithOverlappingInfinities() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, 0.0);
        Range range2 = new Range(0.0, Double.POSITIVE_INFINITY);
        Range expected = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range result = Range.combine(range1, range2);
        assertEquals("Combining ranges with overlapping infinities", expected, result);
    }

    @Test
    public void testCombine_OneRangeEntirelyInfinite() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range range2 = new Range(1.0, 2.0);
        Range expected = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range result = Range.combine(range1, range2);
        assertEquals("One range entirely infinite", expected, result);
    }

}
