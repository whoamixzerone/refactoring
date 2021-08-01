package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest2 {

    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void add_null_or_empty() {
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    public void add_one_number() throws Exception {
        assertEquals(1, cal.add("1"));
    }

    @Test
    public void add_comma() throws Exception {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void add_comma_or_colon() throws Exception {
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void add_custom() throws Exception {
        assertEquals(6, cal.add("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception {
        cal.add("-1,2,3");
    }

}