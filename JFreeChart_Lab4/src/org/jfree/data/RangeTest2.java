package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest2 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}
	
	@Test
	public void getUpperBoundWithPositiveRange() {
		exampleRange = new Range(3.0, 7.0);
		assertEquals("The upper bound of a positive range should be the higher value", 7.0, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundWithNegativeRange() {
		exampleRange = new Range(-7.0, -3.0);
		assertEquals("The upper bound of a negative range should be the less negative value", -3.0, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundAtZeroBoundary() {
		exampleRange = new Range(-7.0, 0.0);
		assertEquals("The upper bound at zero boundary should be 0.0", 0.0, exampleRange.getUpperBound(), 0.000000001d);
	}
		
	@Test
	public void getUpperBoundWithVeryLargeValues() {
	    exampleRange = new Range(1.0E308, 1.7E308);
	    assertEquals("The upper bound with very large values should be correctly handled",
	            1.7E308, exampleRange.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void getUpperBoundWithHighPrecision() {
	    exampleRange = new Range(0.12345678901234567, 0.9876543210987654);
	    assertEquals("The upper bound with high precision should be correctly handled",
	            0.9876543210987654, exampleRange.getUpperBound(), 0.0000000000000001d);
	}
	@Test
    public void getUpperBoundWithBothBoundsPositiveInfinity() {
        exampleRange = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("The upper bound when both bounds are Positive Infinity should be Positive Infinity",
                Double.POSITIVE_INFINITY, exampleRange.getUpperBound(), 0.0);
    }

    @Test
    public void getUpperBoundWithBothBoundsNegativeInfinity() {
        exampleRange = new Range(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        assertEquals("The upper bound when both bounds are Negative Infinity should be Negative Infinity",
                Double.NEGATIVE_INFINITY, exampleRange.getUpperBound(), 0.0);
    }

    @Test
    public void getUpperBoundWithMixedInfinityBounds() {
        exampleRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("The upper bound with mixed Infinity bounds should be Positive Infinity",
                Double.POSITIVE_INFINITY, exampleRange.getUpperBound(), 0.0);
    }

    @Test
    public void getUpperBoundWithUpperBoundNaN() {
        exampleRange = new Range(1.0, Double.NaN);
        assertTrue("The upper bound when upper is NaN should return NaN",
                Double.isNaN(exampleRange.getUpperBound()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUpperBoundWithInvalidRangeShouldThrowException() {
        // This is to clarify the expected behavior when creating a range with invalid bounds,
        // which contradicts the provided "getUpperBoundWithInvalidRange" test case.
        new Range(7.0, 6.0);
    }
	
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}

}