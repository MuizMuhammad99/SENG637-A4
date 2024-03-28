package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest6 {
	
	private static final double DELTA = 0.0000001;

	@Test
    public void testCentralValueWithPositiveRange() {
        Range range = new Range(1.0, 9.0);
        assertEquals("The central value of a positive range should be correct", 5.0, range.getCentralValue(), 0.000000001d);
    }

    @Test
    public void testCentralValueWithNegativeRange() {
        Range range = new Range(-9.0, -1.0);
        assertEquals("The central value of a negative range should be correct", -5.0, range.getCentralValue(), 0.000000001d);
    }

    @Test
    public void testCentralValueWithZeroIncluded() {
        Range range = new Range(-5.0, 5.0);
        assertEquals("The central value of a range including zero should be correct", 0.0, range.getCentralValue(), 0.000000001d);
    }

    @Test
    public void testCentralValueWithZeroWidthRange() {
        Range range = new Range(5.0, 5.0);
        assertEquals("The central value of a zero-width range should be equal to its bounds", 5.0, range.getCentralValue(), 0.000000001d);
    }

    @Test
    public void testCentralValueWithVeryLargeRange() {
        Range range = new Range(1.0E30, 1.0E32);
        assertEquals("The central value of a very large range should be correctly calculated", 5.05E31, range.getCentralValue(), 0.000000001E30);
    }

    @Test
    public void testCentralValueWithVerySmallRange() {
        Range range = new Range(-1.0E-30, 1.0E-30);
        assertEquals("The central value of a very small range should be correctly calculated", 0.0, range.getCentralValue(), 0.000000001E-30);
    }
    
    @Test
    public void testGetCentralValueWithDecrementedLower() {
        Range original = new Range(10, 20);
        Range decrementedLower = new Range(9, 20); // lower decremented by 1
        assertEquals(15, original.getCentralValue(), DELTA);
        assertEquals(14.5, decrementedLower.getCentralValue(), DELTA);
    }

    @Test
    public void testGetCentralValueWithDecrementedUpper() {
        Range original = new Range(10, 20);
        Range decrementedUpper = new Range(10, 19); // upper decremented by 1
        assertEquals(15, original.getCentralValue(), DELTA);
        assertEquals(14.5, decrementedUpper.getCentralValue(), DELTA);
    }

    @Test
    public void testGetCentralValueWithIncrementedLower() {
        Range original = new Range(10, 20);
        Range incrementedLower = new Range(11, 20); // lower incremented by 1
        assertEquals(15, original.getCentralValue(), DELTA);
        assertEquals(15.5, incrementedLower.getCentralValue(), DELTA);
    }

    @Test
    public void testGetCentralValueWithIncrementedUpper() {
        Range original = new Range(10, 20);
        Range incrementedUpper = new Range(10, 21); // upper incremented by 1
        assertEquals(15, original.getCentralValue(), DELTA);
        assertEquals(15.5, incrementedUpper.getCentralValue(), DELTA);
    }

}
