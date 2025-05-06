package com.prep4faang.prep.dsa.twopointer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinMovesToMakePalindromeTest {

    @Test
    @DisplayName("Sample case: eggeekgbbeg → 7 moves")
    void testSample() {
        assertEquals(7, MinMovesToMakePalindrome.minMovesToMakePalindrome("eggeekgbbeg"));
    }

    @Test
    @DisplayName("Even length with two swaps needed: aabb → 2")
    void testEvenLength() {
        assertEquals(2, MinMovesToMakePalindrome.minMovesToMakePalindrome("aabb"));
    }

    @Test
    @DisplayName("Odd length with centre char: mamad → 3")
    void testOddLength() {
        assertEquals(3, MinMovesToMakePalindrome.minMovesToMakePalindrome("mamad"));
    }

    @Test
    @DisplayName("Already a palindrome: abba → 0")
    void testAlreadyPalindrome() {
        assertEquals(0, MinMovesToMakePalindrome.minMovesToMakePalindrome("abba"));
    }

    @Test
    @DisplayName("Single character: a → 0")
    void testSingleChar() {
        assertEquals(0, MinMovesToMakePalindrome.minMovesToMakePalindrome("a"));
    }

}
