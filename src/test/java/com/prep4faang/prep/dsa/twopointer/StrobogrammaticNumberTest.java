package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StrobogrammaticNumberTest {

    // Test case 1: Valid Strobogrammatic Number - "69"
    @Test
    public void testValidStrobogrammaticNumber() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("69"));
    }

    // Test case 2: Invalid Strobogrammatic Number - "962"
    @Test
    public void testInvalidStrobogrammaticNumber() {
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("962"));
    }

    // Test case 3: Valid Strobogrammatic Number - "88"
    @Test
    public void testValidStrobogrammaticNumberWith88() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("88"));
    }

    // Test case 4: Invalid Strobogrammatic Number - "25"
    @Test
    public void testInvalidStrobogrammaticNumberWith25() {
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("25"));
    }

    // Test case 5: Single Digit Strobogrammatic - "1"
    @Test
    public void testSingleDigitStrobogrammatic() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("1"));
    }

    // Test case 6: Number with Leading Zeros - "0"
    @Test
    public void testNumberWithLeadingZero() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("0"));
    }

    // Test case 7: Valid Strobogrammatic Number - "818"
    @Test
    public void testValidStrobogrammaticNumberWith818() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("818"));
    }

    // Test case 8: Invalid Strobogrammatic Number - "123"
    @Test
    public void testInvalidStrobogrammaticNumberWith123() {
        assertFalse(StrobogrammaticNumber.isStrobogrammatic("123"));
    }

    // Test case 9: Invalid Strobogrammatic Number - "609"
    @Test
    public void testInvalidStrobogrammaticNumberWith609() {
        assertTrue(StrobogrammaticNumber.isStrobogrammatic("609"));
    }
}
