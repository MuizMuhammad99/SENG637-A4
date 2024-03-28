package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeContainsTest 
{
    private Range exampleRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-10, 10);
    }


    @Test
    public void containsValueShouldBeTrueForOne() {
        assertTrue("The range should contain the value of 1",
        exampleRange.contains(1));
    }
    
    @Test
    public void containsValueShouldBeFalseForEleven() {
        assertFalse("The range should not contain the value of 11",
        exampleRange.contains(11));
    }
    
    @Test
    public void containsValueShouldBeTrueForTen() {
        assertTrue("The range should contain the value of 10",
        exampleRange.contains(10));
    }
    
    @Test
    public void containsValueShouldBeFalseForA() {
        assertFalse("The range should not contain the letter A",
        exampleRange.contains('A'));
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
