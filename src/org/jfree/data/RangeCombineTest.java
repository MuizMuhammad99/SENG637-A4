package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeCombineTest
{
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void bothNullRangeReturnsNull() {
    	
        assertNull("The range should be null since both ranges are null",
        Range.combine(null, null));
    }
    
    @Test
    public void firstNullRangeReturnsSecond() {
    	Range range1 = new Range (-10, 10);
        assertEquals("The second range should be returned since first is null",
        range1, Range.combine(null, range1));
    }
    
    @Test
    public void secondNullRangeReturnsFirst() {
    	Range range1 = new Range (1, 10);
        assertEquals("The first range should be returned since second is null",
        range1, Range.combine(range1, null));
    }
    
    @Test
    public void bothRangesOverlapping() {
    	Range range1 = new Range (1, 10);
    	Range range2 = new Range (-2, 5);
    	Range expected = new Range (-2, 10);
        assertEquals("The expected range should be (-2, 10)",
        expected, Range.combine(range1, range2));
    }
    
    @Test
    public void bothRangesNotOverlapping() {
    	Range range1 = new Range (1, 10);
    	Range range2 = new Range (-20, -10);
    	Range expected = new Range (-20, 10);
        assertEquals("The expected range should be (-20, 10)",
        expected, Range.combine(range1, range2));
    }
    
    @Test
    public void combineAdjacentRanges() {
        Range range1 = new Range(1.0, 5.0);
        Range range2 = new Range(5.0, 10.0);
        Range expected = new Range(1.0, 10.0);
        assertEquals("Combining adjacent ranges should result in a single range covering both",
                expected, Range.combine(range1, range2));
    }
    
    @Test
    public void combineContainedRanges() {
        Range range1 = new Range(1.0, 10.0);
        Range range2 = new Range(3.0, 7.0); // Completely inside range1
        Range expected = new Range(1.0, 10.0); // Should remain unchanged as range2 is contained within range1
        assertEquals("Combining a range with another range contained within it should not change the original range",
                expected, Range.combine(range1, range2));
    }
    
    @Test
    public void combineRangesWithExtremeValues() {
        Range range1 = new Range(-1.0E308, 1.0E308);
        Range range2 = new Range(1.0E308, 1.7E308);
        Range expected = new Range(-1.0E308, 1.7E308);
        assertEquals("Combining ranges with extreme values should correctly handle the entire range",
                expected, Range.combine(range1, range2));
    }

    @Test
    public void combineRangesWithHighPrecision() {
        Range range1 = new Range(0.1234567890123456, 0.9876543210987654);
        Range range2 = new Range(0.9876543210987654, 0.9999999999999999);
        Range expected = new Range(0.1234567890123456, 0.9999999999999999);
        assertEquals("Combining ranges with high precision numbers should accurately represent the combined range",
                expected, Range.combine(range1, range2));
    }


    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
