package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCalculateColumnTotal {

	@Test
    public void calculateColumnTotalForEmptyValues() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(0.0, result, .000000001d);
    }
    
	@Test
	public void calculateColumnTotalForNegativeRowCount() {
	    Mockery mockingContext = new Mockery();
	    final Values2D values = mockingContext.mock(Values2D.class);

	    mockingContext.checking(new Expectations() {{
	        oneOf(values).getRowCount();
	        will(returnValue(0));
	    }});

	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(0.0, result, .000000001d);
	}
    
    @Test
    public void calculateColumnTotalForLargeValues() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(2));
            oneOf(values).getValue(0, 0);
            will(returnValue(Double.MAX_VALUE));
            oneOf(values).getValue(1, 0);
            will(returnValue(Double.MIN_VALUE));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE, result, .000000001d);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void calculateColumnTotalInvalidData() {
    	DataUtilities.calculateColumnTotal(null, 0);
    }
    
    @Test
    public void calculateColumnTotalForSingleValue() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(1));
            oneOf(values).getValue(0, 0);
            will(returnValue(5.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(5.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalForZeroColumnIndex() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            allowing(values).getValue(0, 0);
            will(returnValue(2.0));
            allowing(values).getValue(1, 0);
            will(returnValue(3.0));
            allowing(values).getValue(2, 0);
            will(returnValue(4.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 0);

        assertEquals(2.0 + 3.0 + 4.0, result, .000000001d);
    }

    @Test
    public void calculateColumnTotalForNonZeroColumnIndex() {
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);

        mockingContext.checking(new Expectations() {{
            oneOf(values).getRowCount();
            will(returnValue(3));
            allowing(values).getValue(0, 1);
            will(returnValue(2.0));
            allowing(values).getValue(1, 1);
            will(returnValue(3.0));
            allowing(values).getValue(2, 1);
            will(returnValue(4.0));
        }});

        double result = DataUtilities.calculateColumnTotal(values, 1);

        assertEquals(2.0 + 3.0 + 4.0, result, .000000001d);
    }

    
    
}
