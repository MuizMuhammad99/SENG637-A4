package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilitiesCreateNumberArray2D {

	@Test
    public void createNumberArray2DEmptyArray() {
       double[][] dataCreated =  {};
       Number[][] dataExpected = DataUtilities.createNumberArray2D(dataCreated);
       
       assertArrayEquals(new Number[][]{}, dataExpected);
    }
    
    @Test
    public void createNumberArray2DNull() {
        double[][] dataCreated = {{}};
        DataUtilities.createNumberArray2D(dataCreated);
    }
    
    @Test
    public void createNumberArray2DExtremeValues() {
    	double[][] dataCreated = {
                {Double.MAX_VALUE, Double.MIN_VALUE},
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}
        };
       Number[][] dataExpected = DataUtilities.createNumberArray2D(dataCreated);
       
       assertEquals(Double.MAX_VALUE, dataExpected[0][0]);
       assertEquals(Double.MIN_VALUE, dataExpected[0][1]);
       assertEquals(Double.POSITIVE_INFINITY, dataExpected[1][0]);
       assertEquals(Double.NEGATIVE_INFINITY, dataExpected[1][1]);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArray2DInvalidType() {
       Number[][] dataCreated =  {{1.0, 2.0, 3.0}, {4.0, 5.0,6.0}};
       Number[][] dataExpected = DataUtilities.createNumberArray2D(null);
           }

}