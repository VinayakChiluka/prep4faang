package com.prep4faang.prep.dsa.twopointer;

/**
 * Problem Statement:
 *
 * Valid Palindrome
 * ----------------
 * Given a string `s`, return TRUE if it is a palindrome; otherwise, return FALSE.
 *
 * A phrase is considered a palindrome if it reads the same backward as forward after:
 * - converting all uppercase letters to lowercase
 * - removing all characters that are not letters or digits (i.e., only alphanumeric characters are considered)
 *
 * Constraints:
 * - 1 <= s.length <= 3000
 * - s consists only of printable ASCII characters
 */

public class PalindromeValidator {

    /**
     * Checks whether the given string is a valid palindrome.
     *
     * @param s The input string to be validated.
     * @return true if the input string is a valid palindrome; false otherwise.
     */
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        // Traverse the string from both ends
        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move pointers toward the center
            left++;
            right--;
        }

        // All characters matched; it's a palindrome
        return true;
    }

}
