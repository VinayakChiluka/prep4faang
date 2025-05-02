package com.prep4faang.prep.dsa.twopointer;// Import necessary JUnit 5 annotations and assertion utilities
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Define the test class for PalindromeValidator
class PalindromeValidatorTest {

    // Declare a PalindromeValidator instance to use in tests
    private PalindromeValidator validator;

    /**
     * This method is run before each test case.
     * It initializes the validator instance.
     */
    @BeforeEach
    void setUp() {
        validator = new PalindromeValidator(); // Create a new instance before each test
    }

    /**
     * Test for a valid palindrome that includes punctuation and spaces.
     */
    @Test
    void testValidPalindromeWithPunctuation() {
        String input = "A man, a plan, a canal: Panama"; // Input with punctuation and spaces
        assertTrue(validator.isPalindrome(input),
                "Expected true for valid palindrome with punctuation");
    }

    /**
     * Test for an invalid palindrome string.
     */
    @Test
    void testInvalidPalindrome() {
        String input = "race a car"; // Not a valid palindrome
        assertFalse(validator.isPalindrome(input),
                "Expected false for non-palindrome");
    }

    /**
     * Edge case: empty string should return true (trivially a palindrome).
     */
    @Test
    void testEmptyString() {
        String input = ""; // Empty string
        assertTrue(validator.isPalindrome(input),
                "Empty string should be a palindrome");
    }

    /**
     * Edge case: single character strings are palindromes.
     */
    @Test
    void testSingleCharacter() {
        String input = "a"; // Single letter
        assertTrue(validator.isPalindrome(input),
                "Single character should be a palindrome");
    }

    /**
     * Test case: string with only non-alphanumeric characters.
     * After cleanup, it's treated as empty => palindrome.
     */
    @Test
    void testOnlyNonAlphanumericCharacters() {
        String input = ".,;:!?"; // Non-alphanumeric characters only
        assertTrue(validator.isPalindrome(input),
                "Only non-alphanumeric characters should be treated as empty => palindrome");
    }

    /**
     * Test for numeric palindrome strings.
     */
    @Test
    void testPalindromeWithNumbers() {
        String input = "12321"; // Palindrome number
        assertTrue(validator.isPalindrome(input),
                "Expected true for numeric palindrome");
    }

    /**
     * Test case with mixed upper and lower case letters.
     */
    @Test
    void testMixedCasePalindrome() {
        String input = "Noon"; // Same forward and backward ignoring case
        assertTrue(validator.isPalindrome(input),
                "Expected true for mixed case palindrome");
    }

    /**
     * Test case: null input should return false.
     */
    @Test
    void testNullInput() {
        assertFalse(validator.isPalindrome(null),
                "Null input should return false");
    }
}
