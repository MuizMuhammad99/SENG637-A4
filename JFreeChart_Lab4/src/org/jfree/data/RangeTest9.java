package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest9 {

	@Test
    public void testExpandTypicalRange() {
        Range original = new Range(10, 20);
        Range expanded = Range.expand(original, 0.1, 0.1); // 10% expansion on both sides
        assertEquals("Expanded range lower bound is incorrect", 9, expanded.getLowerBound(), 0.0000001d);
        assertEquals("Expanded range upper bound is incorrect", 21, expanded.getUpperBound(), 0.0000001d);
    }

    @Test
    public void testExpandZeroMargins() {
        Range original = new Range(5, 15);
        Range expanded = Range.expand(original, 0.0, 0.0); // No expansion
        assertEquals("Range should not change when expanded by zero margins", original, expanded);
    }

    @Test
    public void testExpandNegativeMargins() {
        Range original = new Range(10, 20);
        Range contracted = Range.expand(original, -0.1, -0.1); // 10% contraction
        assertEquals("Contracted range lower bound is incorrect", 11, contracted.getLowerBound(), 0.0000001d);
        assertEquals("Contracted range upper bound is incorrect", 19, contracted.getUpperBound(), 0.0000001d);
    }

    @Test
    public void testExpandWithLargeMargins() {
        Range original = new Range(0, 100);
        Range expanded = Range.expand(original, 1.0, 1.0); // 100% expansion on both sides
        assertEquals("Expanded range lower bound with large margins is incorrect", -100, expanded.getLowerBound(), 0.0000001d);
        assertEquals("Expanded range upper bound with large margins is incorrect", 200, expanded.getUpperBound(), 0.0000001d);
    }

    @Test
    public void testExpandSinglePoint() {
        Range original = new Range(50, 50); // Single point
        Range expanded = Range.expand(original, 0.5, 0.5); // 50% expansion, which should have effect
        assertEquals("Expanded range of a single point should correctly adjust lower bound", 25, expanded.getLowerBound(), 0.0000001d);
        assertEquals("Expanded range of a single point should correctly adjust upper bound", 75, expanded.getUpperBound(), 0.0000001d);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExpandNullRange() {
        Range.expand(null, 0.1, 0.1); // Should throw IllegalArgumentException
    }
    
    @Test
    public void testExpandRangeWithInfiniteBounds() {
        Range original = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range expanded = Range.expand(original, 0.1, 0.1); // Expanding infinity by any finite factor should still be infinity
        assertTrue("Expanded range with infinite bounds should still have infinite bounds",
                expanded.getLowerBound() == Double.NEGATIVE_INFINITY &&
                expanded.getUpperBound() == Double.POSITIVE_INFINITY);
    }

    @Test
    public void testExpandAsymmetricMargins() {
        Range original = new Range(10, 20);
        Range expanded = Range.expand(original, 0.2, 0.5); // Different expansion factors for lower and upper bounds
        assertEquals("Expanded range lower bound with asymmetric margins is incorrect", 8, expanded.getLowerBound(), 0.0000001d);
        assertEquals("Expanded range upper bound with asymmetric margins is incorrect", 25, expanded.getUpperBound(), 0.0000001d);
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testExpandRangeWithCrossoverBounds() {
//        Range original = new Range(10, 20);
//        Range.expand(original, 1.5, -0.5); // This would result in lower bound being greater than upper bound, which is invalid
//    }

//    @Test
//    public void testExpandRangeIncludingNaN() {
//        Range original = new Range(Double.NaN, 10.0);
//        Range expanded = Range.expand(original, 0.1, 0.1); // Including NaN should likely result in NaN on that side
//        assertTrue("Expanded range including NaN should have NaN as lower bound",
//                Double.isNaN(expanded.getLowerBound()));
//        assertEquals("Expanded range including NaN should have correct upper bound", 11, expanded.getUpperBound(), 0.0000001d);
//    }

    @Test
    public void testExpandZeroWidthRangeToNegativeMargins() {
        Range original = new Range(50, 50); // Single point
        Range contracted = Range.expand(original, -0.1, -0.1); // Negative margins should not affect a zero-width range
        assertEquals("Contracted range of a single point should still be a single point", 50, contracted.getLowerBound(), 0.0000001d);
        assertEquals("Contracted range of a single point should still be a single point", 50, contracted.getUpperBound(), 0.0000001d);
    }

}
