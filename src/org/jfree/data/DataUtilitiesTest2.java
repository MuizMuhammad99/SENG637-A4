package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jmock.Mockery;
import org.jmock.Expectations;

public class DataUtilitiesTest2 {

	private Mockery mockingContext;
	private Values2D values;
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	}
    
	@Test
    public void calculateRowTotalForTwoValidCols() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(3));
            allowing(values).getValue(0, 0);
            will(returnValue(5.0));
            allowing(values).getValue(0, 1);
            will(returnValue(3.0));
            allowing(values).getValue(0, 2);
            will(returnValue(2.0));
        }});

        // exercise
        int[] validCols = {0, 2};
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);

        // verify
        assertEquals(7.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test
    public void calculateRowTotalForEmptyRowWithValidCols() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(0)); 
            
        }});

        // exercise
        int[] validCols = {};
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);

        // verify
        assertEquals(0.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test
    public void calculateRowTotalForSingleValueWithValidCols() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(1));
            oneOf(values).getValue(0,0);
            will(returnValue(5.0));
        }});

        // exercise
        int[] validCols = {0};
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);

        // verify
        assertEquals(5.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void calculateRowTotalInvalidDataWithValidCols() {
        int[] validCols = {0, 1};
        DataUtilities.calculateRowTotal(null, 0, validCols);
    }

	@Test(expected = IllegalArgumentException.class)

	public void calculateRowTotalInvalidValidCols() {
	    final Values2D values = mockingContext.mock(Values2D.class);
	    mockingContext.checking(new Expectations() {{
	        oneOf(values).getColumnCount();
	        will(returnValue(3));
	    }});
	    mockingContext.checking(new Expectations() {{
	        allowing(values).getValue(0, 0);
	        will(returnValue(1));
	        allowing(values).getValue(0, 3);
	    }});
	    int[] invalidCols = {0, 3};
	    DataUtilities.calculateRowTotal(values, 0, invalidCols);
	}
	
	@Test
    public void calculateRowTotalWithMixedValuesAndValidCols() {
        mockingContext.checking(new Expectations() {{
            oneOf(values).getColumnCount();
            will(returnValue(4));
            oneOf(values).getValue(0,0);
            will(returnValue(5.0));
            oneOf(values).getValue(0,1);
            will(returnValue(-3.0));
            oneOf(values).getValue(0,2);
            will(returnValue(10.0));
            oneOf(values).getValue(0,3);
            will(returnValue(2.0));
        }});

        // exercise
        int[] validCols = {0,1, 2, 3};
        double result = DataUtilities.calculateRowTotal(values, 0, validCols);

        // verify
        assertEquals(14.0, result, .000000001d);

        // tear-down: NONE in this test method
	}
	
	@After
	public void tearDown() throws Exception {
		mockingContext.assertIsSatisfied();
	}
}
