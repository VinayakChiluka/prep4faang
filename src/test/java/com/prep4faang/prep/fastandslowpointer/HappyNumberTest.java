package com.prep4faang.prep.fastandslowpointer;

import com.prep4faang.prep.dsa.fastandslow.HappyNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HappyNumberTest {

    HappyNumber hn = new HappyNumber();

    @Test
    public void testHappyNumbers() {
        assertTrue(hn.isHappy(1), "1 should be a happy number");
        assertTrue(hn.isHappy(7), "7 should be a happy number");
        assertTrue(hn.isHappy(10), "10 should be a happy number");
        assertTrue(hn.isHappy(19), "19 should be a happy number");
        assertTrue(hn.isHappy(100), "100 should be a happy number");
        assertTrue(hn.isHappy(68), "68 should be a happy number");
    }

    @Test
    public void testUnhappyNumbers() {
        assertFalse(hn.isHappy(2), "2 is not a happy number");
        assertFalse(hn.isHappy(3), "3 is not a happy number");
        assertFalse(hn.isHappy(4), "4 is not a happy number");
        assertFalse(hn.isHappy(20), "20 is not a happy number");
        assertFalse(hn.isHappy(21), "21 is not a happy number");
    }

    @Test
    public void testEdgeCases() {
        assertTrue(hn.isHappy(1), "Minimum valid input (1) should be happy");
        assertDoesNotThrow(() -> hn.isHappy(Integer.MAX_VALUE), "Should handle Integer.MAX_VALUE without crashing");
    }

    @Test
    public void testLargeUnhappyNumber() {
        assertFalse(hn.isHappy(987654321), "987654321 is not a happy number");
    }

    @Test
    public void testLargeHappyNumber() {
        assertTrue(hn.isHappy(1000000), "1000000 should be a happy number");
    }
}
