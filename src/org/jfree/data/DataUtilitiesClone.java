package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilitiesClone {

	@Test
    public void cloneArray() {
        double[][] a = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] b = DataUtilities.clone(a);
        assertNotSame(a, b);
        assertArrayEquals(a, b);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cloneNullArray() {
    	double[][] a = null;
    	DataUtilities.clone(a);
    }

    @Test
    public void cloneEmptyArray() {
        double[][] a = {};
        double[][] b = DataUtilities.clone(a);
        assertNotSame(a, b);
        assertArrayEquals(a, b);
    }

    @Test
    public void cloneArrayWithNaN() {
        double[][] a = {{1.0, 2.0, 3.0, Double.NaN, 5.0}, {6.0, 7.0, 8.0, Double.NaN, 10.0}};
        double[][] b = DataUtilities.clone(a);
        assertNotSame(a, b);
        assertArrayEquals(a, b);
    }

    @Test
    public void cloneArrayWithInfinity() {
        double[][] a = {{1.0, 2.0, 3.0, 4.0, 5.0}, {6.0, 7.0, 8.0, 9.0, Double.POSITIVE_INFINITY}};
        double[][] b = DataUtilities.clone(a);
        assertNotSame(a, b);
        assertArrayEquals(a, b);
    }

}
