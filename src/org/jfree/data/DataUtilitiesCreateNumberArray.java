package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilitiesCreateNumberArray {

	@Test(expected = IllegalArgumentException.class)
    public void createNumberArrayInvalidType() {
       Number[] dataCreated =  {1.0, 2.0, 3.0, 4.0, 5.0};
       Number[] dataExpected = DataUtilities.createNumberArray(null);
           }
    
    @Test
    public void createNumberArrayEmptyArray() {
       double[] dataCreated =  {};
       Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
       
       assertArrayEquals(new Number[]{}, dataExpected);
    }
    
    @Test
    public void createNumberArrayExtremeValues() {
       double[] dataCreated =  {-Double.MAX_VALUE, -5.0,  0.0, 5.0, Double.MAX_VALUE};
       Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
       
       assertArrayEquals(new Number[]{-Double.MAX_VALUE, -5.0,  0.0, 5.0, Double.MAX_VALUE}, dataExpected);
    }
    
    @Test
    public void createNumberArrayDifferentTypes() {
        double[] dataCreated =  {-5.0, 0.0, 5.0};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertNotSame(new Number[]{-5, 0, 5}, dataExpected);
     }

    @Test
    public void createNumberArrayValidInput() {
        double[] dataCreated = {1.0, 2.0, 3.0, 4.0, 5.0};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertArrayEquals(new Number[]{1.0, 2.0, 3.0, 4.0, 5.0}, dataExpected);
    }
    
    @Test
    public void createNumberArrayMixedValues() {
        double[] dataCreated = {-1.0, 0.0, 1.0};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertArrayEquals(new Number[]{-1.0, 0.0, 1.0}, dataExpected);
    }
    
    @Test
    public void createNumberArrayZeroValues() {
        double[] dataCreated = {0.0, 0.0, 0.0};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertArrayEquals(new Number[]{0.0, 0.0, 0.0}, dataExpected);
    }
    
    @Test
    public void createNumberArrayNaNValues() {
        double[] dataCreated = {Double.NaN, Double.NaN, Double.NaN};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertArrayEquals(new Number[]{Double.NaN, Double.NaN, Double.NaN}, dataExpected);
    }
    
    @Test
    public void createNumberArrayInfinityValues() {
        double[] dataCreated = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
        Number[] dataExpected = DataUtilities.createNumberArray(dataCreated);
        
        assertArrayEquals(new Number[]{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY}, dataExpected);
    }
    
}
