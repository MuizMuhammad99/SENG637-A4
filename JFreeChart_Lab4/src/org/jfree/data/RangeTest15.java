package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest15 {

	@Test
    public void testHashCodeConsistency() {
        Range range = new Range(1.0, 5.0);
        int hashCode1 = range.hashCode();
        int hashCode2 = range.hashCode();
        assertEquals("Hash code should remain consistent across multiple invocations", hashCode1, hashCode2);
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.0);
        assertEquals("Equal objects must have equal hash codes", range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeInequalityForNonEqualObjects() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(2.0, 6.0);
        // Note: This test might not always pass due to the possibility of hash collisions,
        // but it's unlikely for these specific cases.
        assertNotEquals("Non-equal objects should ideally have different hash codes", range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentLowerBounds() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.5, 5.0);
        assertNotEquals("Ranges with different lower bounds should have different hash codes", range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeWithDifferentUpperBounds() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(1.0, 5.5);
        assertNotEquals("Ranges with different upper bounds should have different hash codes", range1.hashCode(), range2.hashCode());
    }
    
    @Test
    public void testHashCodeForIdenticalBounds() {
        Range range1 = new Range(3.0, 3.0);
        Range range2 = new Range(3.0, 3.0);
        assertEquals("Ranges with identical bounds should have equal hash codes",
                     range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeForInfiniteBounds() {
        Range range1 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        Range range2 = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("Ranges with infinite bounds should have equal hash codes",
                     range1.hashCode(), range2.hashCode());
    }

    @Test
    public void testHashCodeWithNaNBound() {
        Range range1 = new Range(Double.NaN, 5.0);
        Range range2 = new Range(Double.NaN, 5.0);
        assertEquals("Ranges with NaN in bounds should treat NaN consistently in hash code calculation",
                     range1.hashCode(), range2.hashCode());
    }
    
}
