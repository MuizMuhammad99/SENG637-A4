package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest3 {
	private Range exampleRange;
	
	@Before
	public void setUp() throws Exception {
		// No universal setup required for these tests
	}

	@Test
	public void getLengthWithPositiveRange() {
		exampleRange = new Range(4.0, 10.0);
		assertEquals("The length of a positive range 4.0 to 10.0 should be 6.0", 6.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithNegativeRange() {
		exampleRange = new Range(-10.0, -4.0);
		assertEquals("The length of a negative range -10.0 to -4.0 should be 6.0", 6.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthAtZeroCrossing() {
		exampleRange = new Range(-7.0, 7.0);
		assertEquals("The length of a range crossing zero -7.0 to 7.0 should be 14.0", 14.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithZeroWidthRange() {
		exampleRange = new Range(9.0, 9.0);
		assertEquals("The length of a zero-width range 9.0 to 9.0 should be 0.0", 0.0, exampleRange.getLength(), 0.000000001d);
	}
	
	@Test
	public void getLengthWithVeryLargeNumbers() {
	    exampleRange = new Range(1.0E307, 1.7E307);
	    assertEquals("The length of a range with very large numbers should be accurately calculated",
	            0.7E307, exampleRange.getLength(), 1.0E300);
	}
	
	@Test
	public void getLengthWithVerySmallNumbers() {
	    exampleRange = new Range(-1.0E-308, 1.0E-308);
	    assertEquals("The length of a range with very small numbers should be accurately calculated",
	            2.0E-308, exampleRange.getLength(), 0.0);
	}
	
	@Test
	public void getLengthWithInfiniteRange() {
	    exampleRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	    assertTrue("The length of an infinite range should be positive infinity",
	            Double.isInfinite(exampleRange.getLength()) && exampleRange.getLength() > 0);
	}

	@Test
	public void getLengthWithUpperBoundInfinity() {
	    exampleRange = new Range(1.0, Double.POSITIVE_INFINITY);
	    assertTrue("The length of a range with positive infinity as upper bound should be positive infinity",
	            Double.isInfinite(exampleRange.getLength()) && exampleRange.getLength() > 0);
	}

	@Test
	public void getLengthWithLowerBoundInfinity() {
	    exampleRange = new Range(Double.NEGATIVE_INFINITY, -1.0);
	    assertTrue("The length of a range with negative infinity as lower bound should be positive infinity",
	            Double.isInfinite(exampleRange.getLength()) && exampleRange.getLength() > 0);
	}

	@Test
	public void getLengthWithNaNValues() {
	    exampleRange = new Range(Double.NaN, Double.NaN);
	    assertTrue("The length of a range with NaN values should be NaN",
	            Double.isNaN(exampleRange.getLength()));
	}

	@Test
	public void getLengthWithMixedSignExtremes() {
	    exampleRange = new Range(-Double.MAX_VALUE, Double.MAX_VALUE);
	    assertTrue("The length of a range with mixed sign extremes should be positive infinity",
	            Double.isInfinite(exampleRange.getLength()) && exampleRange.getLength() > 0);
	}

//	@Test
//	public void getLengthWithEpsilonDifference() {
//	    exampleRange = new Range(1.0, 1.0 + Double.MIN_VALUE);
//	    assertEquals("The length of a range with an epsilon difference should be Double.MIN_VALUE",
//	            Double.MIN_VALUE, exampleRange.getLength(), 0.0);
//	}

	@Test
	public void getLengthWithNegativeZero() {
	    exampleRange = new Range(-0.0, 0.0);
	    assertEquals("The length of a range from negative zero to zero should be zero",
	            0.0, exampleRange.getLength(), 0.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getLengthWithReversedBounds() {
	    // This test checks if the constructor correctly throws an exception for invalid bounds,
	    // which is a precondition for the getLength() method.
	    new Range(10.0, 5.0);
	}

	@Test
	public void getLengthWithSubnormalRange() {
	    exampleRange = new Range(Double.MIN_NORMAL, 2 * Double.MIN_NORMAL);
	    assertEquals("The length of a range with subnormal values should be calculated correctly",
	            Double.MIN_NORMAL, exampleRange.getLength(), 0.0);
	}
		
	@After
	public void tearDown() throws Exception {
		// No tear-down needed for these tests
	}

}