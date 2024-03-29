package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest4 {

	@Test
    public void toStringWithPositiveRange() {
        Range range = new Range(1.0, 10.0);
        assertEquals("ToString with positive range failed", "Range[1.0,10.0]", range.toString());
    }

    @Test
    public void toStringWithNegativeRange() {
        Range range = new Range(-10.0, -1.0);
        assertEquals("ToString with negative range failed", "Range[-10.0,-1.0]", range.toString());
    }

    @Test
    public void toStringWithMixedRange() {
        Range range = new Range(-5.0, 5.0);
        assertEquals("ToString with mixed range failed", "Range[-5.0,5.0]", range.toString());
    }

    @Test
    public void toStringWithZeroBoundaries() {
        Range range = new Range(0.0, 0.0);
        assertEquals("ToString with zero boundaries failed", "Range[0.0,0.0]", range.toString());
    }

    @Test
    public void toStringWithVeryLargeRange() {
        Range range = new Range(1.0E30, 1.0E31);
        assertEquals("ToString with very large range failed", "Range[1.0E30,1.0E31]", range.toString());
    }

    @Test
    public void toStringWithVerySmallRange() {
        Range range = new Range(-1.0E-30, 1.0E-30);
        assertEquals("ToString with very small range failed", "Range[-1.0E-30,1.0E-30]", range.toString());
    }

    @Test
    public void toStringWithHighPrecisionRange() {
        Range range = new Range(0.1234567890123456, 0.9876543210987654);
        assertEquals("ToString with high precision range failed", "Range[0.1234567890123456,0.9876543210987654]", range.toString());
    }
    
    @Test
    public void toStringWithNaNBoundaries() {
        Range range = new Range(Double.NaN, Double.NaN);
        assertEquals("ToString with NaN boundaries failed", "Range[NaN,NaN]", range.toString());
    }

    @Test
    public void toStringWithInfinityBoundaries() {
        Range range = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("ToString with infinity boundaries failed", "Range[-Infinity,Infinity]", range.toString());
    }

    @Test
    public void toStringWithMixedInfinity() {
        Range range = new Range(-1.0, Double.POSITIVE_INFINITY);
        assertEquals("ToString with mixed infinity failed", "Range[-1.0,Infinity]", range.toString());
    }

    @Test
    public void toStringWithSubnormalValues() {
        Range range = new Range(Double.MIN_VALUE, Double.MIN_VALUE * 2);
        String expected = "Range[" + Double.toString(Double.MIN_VALUE) + "," + Double.toString(Double.MIN_VALUE * 2) + "]";
        assertEquals("ToString with subnormal values failed", expected, range.toString());
    }

    @Test
    public void toStringWithNegativeZero() {
        Range range = new Range(-0.0, -0.0);
        assertEquals("ToString with negative zero failed", "Range[-0.0,-0.0]", range.toString());
    }

    @Test
    public void toStringWithMaxValueBoundaries() {
        Range range = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals("ToString with MAX_VALUE boundaries failed", "Range[" + Double.MAX_VALUE + "," + Double.MAX_VALUE + "]", range.toString());
    }

    @Test
    public void toStringWithPrecisionLoss() {
        Range range = new Range(0.1, 1.0 / 3);
        String expected = "Range[0.1," + (1.0 / 3) + "]";
        assertEquals("ToString with precision loss failed", expected, range.toString());
    }
    
    @Test
    public void toStringShouldFailIfLowerIsIncremented() {
        // Construct a range with lower bound close to a large number where an increment would change the string representation
        double closeToMaxValue = Double.MAX_VALUE - 1;
        Range range = new Range(closeToMaxValue, Double.MAX_VALUE);
        String expected = "Range[" + closeToMaxValue + "," + Double.MAX_VALUE + "]";
        assertEquals("toString should fail if lower is incremented", expected, range.toString());
    }

    @Test
    public void toStringShouldFailIfUpperIsIncremented() {
        // Construct a range where upper bound increment would change the string representation
        double closeToMaxValue = Double.MAX_VALUE - 1;
        Range range = new Range(Double.MAX_VALUE, closeToMaxValue);
        String expected = "Range[" + Double.MAX_VALUE + "," + closeToMaxValue + "]";
        assertEquals("toString should fail if upper is incremented", expected, range.toString());
    }

    @Test
    public void toStringShouldFailIfLowerIsDecremented() {
        // Construct a range where decrementing the lower bound would not change the string representation
        double aboveMinValue = Double.MIN_VALUE + 1;
        Range range = new Range(aboveMinValue, Double.MAX_VALUE);
        String expected = "Range[" + aboveMinValue + "," + Double.MAX_VALUE + "]";
        assertEquals("toString should fail if lower is decremented", expected, range.toString());
    }

    @Test
    public void toStringShouldFailIfUpperIsDecremented() {
        // Construct a range where decrementing the upper bound would change the string representation
        double aboveMinValue = Double.MIN_VALUE + 1;
        Range range = new Range(Double.MIN_VALUE, aboveMinValue);
        String expected = "Range[" + Double.MIN_VALUE + "," + aboveMinValue + "]";
        assertEquals("toString should fail if upper is decremented", expected, range.toString());
    }

}
