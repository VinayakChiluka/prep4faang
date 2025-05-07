package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class NextPalindromeTest {

    /* ---------- public‑API tests ---------- */

    @Test
    @DisplayName("Even length – base example")
    void testEvenLengthNormal() {
        assertEquals("132231",
                NextPalindrome.nextPalindrome("123321"));
    }

    @Test
    @DisplayName("Odd length – base example")
    void testOddLengthNormal() {
        assertEquals("43477434",
                NextPalindrome.nextPalindrome("37444743"));
    }

    @Test
    @DisplayName("Already at maximum permutation → no answer")
    void testNoNextPalindrome() {
        assertEquals("",
                NextPalindrome.nextPalindrome("9876789"));
    }

    @Test
    @DisplayName("Length‑2 edge case with next palindrome")
    void testLengthTwo() {
        assertEquals("",
                NextPalindrome.nextPalindrome("44"));   // largest already
        assertEquals("",
                NextPalindrome.nextPalindrome("55"));   // same
        assertEquals("",
                NextPalindrome.nextPalindrome("66"));   // same
        assertEquals("",
                NextPalindrome.nextPalindrome("99"));   // no larger
    }

    @Test
    @DisplayName("Single‑digit string always returns empty")
    void testSingleDigit() {
        assertEquals("", NextPalindrome.nextPalindrome("7"));
    }

    /* ---------- internal helper tests ---------- */

    @Nested
    @DisplayName("nextPermutation helper")
    class NextPermutationTests {

        @Test
        void testAdvances() {
            List<Character> digits =
                    new ArrayList<>(Arrays.asList('1','2','3'));
            assertTrue(invokeNextPerm(digits));
            assertEquals(Arrays.asList('1','3','2'), digits);
        }

        @Test
        void testAlreadyMax() {
            List<Character> digits =
                    new ArrayList<>(Arrays.asList('3','2','1'));
            assertFalse(invokeNextPerm(digits));
            assertEquals(Arrays.asList('3','2','1'), digits);   // unchanged
        }

        private boolean invokeNextPerm(List<Character> list) {
            // Use reflection because nextPermutation is private
            try {
                var m = NextPalindrome.class
                        .getDeclaredMethod("nextPermutation", List.class);
                m.setAccessible(true);
                return (boolean) m.invoke(null, list);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
