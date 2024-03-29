package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest1 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}
	
	@Test
	public void getLowerBoundWithNegativeRange() {
		exampleRange = new Range(-10.0, -1.0);
		assertEquals("The lower bound of a negative range should be", -10.0, exampleRange.getLowerBound(), 0.000000001d);
	}

	@Test
	public void getLowerBoundWithPositiveRange() {
		exampleRange = new Range(1.0, 10.0);
		assertEquals("The lower bound of a positive range should be the smallest positive value", 1.0, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithZeroLowerBound() {
		exampleRange = new Range(0.0, 10.0);
		assertEquals("The lower bound of a range starting with zero should be zero", 0.0, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithEqualBounds() {
	    exampleRange = new Range(5.0, 5.0);
	    assertEquals("The lower bound of a range with equal bounds should be the same as the upper bound", 5.0, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithVeryLargeValues() {
	    exampleRange = new Range(1.0E308, 1.7E308);
	    assertEquals("The lower bound with very large values should be correctly handled",
	            1.0E308, exampleRange.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void getLowerBoundWithHighPrecision() {
	    exampleRange = new Range(0.12345678901234567, 0.9876543210987654);
	    assertEquals("The lower bound with high precision should be correctly handled",
	            0.12345678901234567, exampleRange.getLowerBound(), 0.0000000000000001d);
	}
	@Test
    public void getLowerBoundWithVerySmallValues() {
        exampleRange = new Range(-1.0E-308, 1.0E-308);
        assertEquals("The lower bound with very small values should be correctly handled",
                -1.0E-308, exampleRange.getLowerBound(), 0.000000001d);
    }
    
    @Test
    public void getLowerBoundWhenLowerIsPositiveInfinity() {
        exampleRange = new Range(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("The lower bound when lower is Positive Infinity should be correctly handled",
                Double.POSITIVE_INFINITY, exampleRange.getLowerBound(), 0.0);
    }
    
    @Test
    public void getLowerBoundWhenLowerIsNegativeInfinity() {
        exampleRange = new Range(Double.NEGATIVE_INFINITY, 1.0);
        assertEquals("The lower bound when lower is Negative Infinity should be correctly handled",
                Double.NEGATIVE_INFINITY, exampleRange.getLowerBound(), 0.0);
    }
    
    @Test
    public void getLowerBoundWithNaNValues() {
        exampleRange = new Range(Double.NaN, Double.NaN);
        assertTrue("The lower bound when both bounds are NaN should be NaN",
                Double.isNaN(exampleRange.getLowerBound()));
    }
    	
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}
	
	
}