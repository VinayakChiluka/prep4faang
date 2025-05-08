package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ValidPalindromeIITest {

    @Test
    void testAlreadyPalindrome() {
        assertTrue(ValidPalindromeII.validPalindrome("abccba"));
    }

    @Test
    void testNeedsOneRemovalMiddle() {
        // remove ‘c’ (index 2 or index 3) to form “abca”
        assertTrue(ValidPalindromeII.validPalindrome("abcacba"));
    }

    @Test
    void testNeedsOneRemovalEdge() {
        // remove trailing ‘a’
        assertTrue(ValidPalindromeII.validPalindrome("abca"));
    }

    @Test
    void testImpossibleEvenAfterRemoval() {
        assertFalse(ValidPalindromeII.validPalindrome("abc"));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(ValidPalindromeII.validPalindrome("x"));
    }

    @Test
    void testMaxLengthAllSame() {
        char[] arr = new char[100_000];
        java.util.Arrays.fill(arr, 'A');
        String s = new String(arr);
        assertTrue(ValidPalindromeII.validPalindrome(s));
    }
}
