package com.prep4faang.prep.slidingwindow;

import com.prep4faang.prep.dsa.slidingwindow.LongestSubstringWithoutRepeating;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingTest {

    @Test
    void testExample1() {
        String input = "abcabcbb";
        int expected = 3;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testExample2() {
        String input = "bbbbb";
        int expected = 1;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testExample3() {
        String input = "pwwkew";
        int expected = 3;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testEmptyString() {
        String input = "";
        int expected = 0;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testAllUniqueCharacters() {
        String input = "abcdef";
        int expected = 6;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testAllSameCharacters() {
        String input = "aaaaaaa";
        int expected = 1;
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testSpecialCharacters() {
        String input = "a!@#a!@#";
        int expected = 4; // "!@#a" or "@#a!" etc.
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }

    @Test
    void testMixedCharacters() {
        String input = "abcdeafgh";
        int expected = 8; // "cdeafgh"
        assertEquals(expected, LongestSubstringWithoutRepeating.lengthOfLongestSubstring(input));
    }
}
