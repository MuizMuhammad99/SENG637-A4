package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilitiesEqual {

	@Test
    public void equalArrays() {
        double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
        double[][] b = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
        assertTrue(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalWithNaN() {
        double[][] a = {{1.0, 2.0, 3.0, Double.NaN, 5.0}, {6.0, 7.0, 8.0, Double.NaN, 10.0}};
        double[][] b = {{1.0, 2.0, 3.0, Double.NaN, 5.0}, {6.0, 7.0, 8.0, Double.NaN, 10.0}};
        assertTrue(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalArraysNullInput() {
		double[][] a = null;
		double[][] b = null;
        assertTrue(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalArraysDifferentDimensions() {
		double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
        double[][] b = {{1.0, 2.0, 3.0, 4.0}, {6.0, 7.0, 8.0, 9.0}};
        assertFalse(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalArraysDifferentValues() {
		double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
        double[][] b = {{11.0, 12.0, 13.0, 14.0, 15.0}, {16.0, 17.0, 18.0, 19.0, 20.0}};
        assertFalse(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalArraysInfinity() {
        double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, Double.POSITIVE_INFINITY}};
        double[][] b = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, Double.POSITIVE_INFINITY}};
        assertTrue(DataUtilities.equal(a, b));
    }
	
	@Test
    public void equalArraysNegativeInfinity() {
        double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, Double.NEGATIVE_INFINITY}};
        double[][] b = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, Double.NEGATIVE_INFINITY}};
        assertTrue(DataUtilities.equal(a, b));
    }
	
	@Test
	public void equalArraysAIsNull() {
	    double[][] a = null;
	    double[][] b = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
	    assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalArraysWithBNull() {
	    double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
	    double[][] b = null;
	    assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalArraysWithDifferentLengths() {
	    double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, 10.0}};
	    double[][] b = {{1.0, 2.0, 3.0, 4.0, 5.0}};
	    assertFalse(DataUtilities.equal(a, b));
	}

}
