package com.prep4faang.prep.dsa.twopointer;

/**
 * Problem: Valid Palindrome II
 *
 * Statement
 * ---------
 * Write a function that takes a string as input and checks whether it can be a
 * valid palindrome after removing **at most one** character.
 *
 * Constraints
 * -----------
 * 1 <= s.length <= 1 0^5
 * The string consists only of English letters (both upper- and lower-case).
 *
 * Approach
 * --------
 * • Use two pointers, `left` (start) and `right` (end).
 * • While characters match, advance both pointers.
 * • When a mismatch occurs, we have only one chance to skip:
 *      – Either skip the character at `left`
 *      – Or skip the character at `right`
 *   Then verify whether the remaining substring is a palindrome.
 * • If at most one skip makes the whole string a palindrome, return true.
 *
 * Complexity
 * ----------
 * Time:  O(n) — each character is inspected at most twice.
 * Space: O(1) — constant auxiliary space.
 */
public class ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // We can remove s[left] **or** s[right] exactly once.
                return isPalindromeRange(s, left + 1, right) ||
                       isPalindromeRange(s, left, right - 1);
            }
        }
        return true; // reached the middle with ≤1 mismatch
    }

    /** Helper: check if s[l..r] (inclusive) is a palindrome. */
    private static boolean isPalindromeRange(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}
