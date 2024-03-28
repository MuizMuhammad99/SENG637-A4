package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest7 {

	@Test
    public void testNonOverlappingRanges() {
        Range baseRange = new Range(1.0, 5.0);
        Range otherRange = new Range(6.0, 10.0);
        assertFalse("Non-overlapping ranges should not intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testPartiallyOverlappingRanges() {
        Range baseRange = new Range(1.0, 5.0);
        Range otherRange = new Range(4.0, 8.0);
        assertTrue("Partially overlapping ranges should intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testFullyOverlappingRanges() {
        Range baseRange = new Range(1.0, 5.0);
        Range otherRange = new Range(2.0, 4.0);
        assertTrue("Fully overlapping ranges should intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testTouchingAtUpperBound() {
        Range baseRange = new Range(1.0, 5.0);
        Range otherRange = new Range(5.0, 10.0);
        assertTrue("Ranges touching at the upper bound should intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testTouchingAtLowerBound() {
        Range baseRange = new Range(5.0, 10.0);
        Range otherRange = new Range(1.0, 5.0);
        assertTrue("Ranges touching at the lower bound should intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testSameRanges() {
        Range baseRange = new Range(1.0, 5.0);
        Range otherRange = new Range(1.0, 5.0);
        assertTrue("Identical ranges should intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testNonOverlappingWithNegativeRanges() {
        Range baseRange = new Range(-10.0, -5.0);
        Range otherRange = new Range(-4.0, 0.0);
        assertFalse("Non-overlapping ranges with negatives should not intersect", baseRange.intersects(otherRange));
    }

    @Test
    public void testOverlappingWithNegativeRanges() {
        Range baseRange = new Range(-10.0, -5.0);
        Range otherRange = new Range(-6.0, -3.0);
        assertTrue("Overlapping ranges with negatives should intersect", baseRange.intersects(otherRange));
    }
    
//    @Test
//    public void testIntersects_DecrementLowerBeforeIntersect() {
//        // Simulate decrementing lower by creating a range just outside the boundary
//        Range base = new Range(2.0, 10.0);
//        Range other = new Range(1.0, 2.0);
//        // Should not intersect if lower is decremented
//        assertFalse("Should not intersect when lower is decremented before check", base.intersects(other));
//    }

//    @Test
//    public void testIntersects_PostDecrementLower() {
//        // Post-decrement simulation
//        Range base = new Range(2.0, 10.0);
//        Range other = new Range(1.99, 2.0);
//        // Close enough to be considered not intersecting after decrement
//        assertFalse("Should not intersect with post-decrement of lower", base.intersects(other));
//    }

    @Test
    public void testIntersects_PostDecrementUpper() {
        // Post-decrement simulation on upper
        Range base = new Range(2.0, 10.0);
        Range other = new Range(10.0, 11.0);
        // Intersects at the edge before upper is post-decremented
        assertTrue("Should intersect with post-decrement of upper", base.intersects(other));
    }

    @Test
    public void testIntersects_IncrementUpperBeforeIntersect() {
        // Simulate incrementing upper
        Range base = new Range(2.0, 10.0);
        Range other = new Range(10.01, 15.0);
        // Should intersect if upper is incremented before check
        assertFalse("Should not intersect when upper is incremented before check", base.intersects(other));
    }

    @Test
    public void testIntersects_PreIncrementLower() {
        // Pre-increment simulation of lower
        Range base = new Range(2.0, 10.0);
        Range other = new Range(0.0, 1.99);
        // Should not intersect if lower is pre-incremented
        assertFalse("Should not intersect with pre-increment of lower", base.intersects(other));
    }

    @Test
    public void testIntersects_PostIncrementUpper() {
        // Post-increment simulation on upper
        Range base = new Range(2.0, 10.0);
        Range other = new Range(9.99, 20.0);
        // Should intersect at the edge before upper is post-incremented
        assertTrue("Should intersect with post-increment of upper", base.intersects(other));
    }

}
