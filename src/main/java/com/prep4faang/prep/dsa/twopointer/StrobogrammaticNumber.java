package com.prep4faang.prep.dsa.twopointer;/*
 * Problem Statement: Strobogrammatic Number
 *
 * Description:
 * Given a string `num` representing an integer, determine whether it is a strobogrammatic number.
 * Return `TRUE` if the number is strobogrammatic or `FALSE` if it is not.
 *
 * Note:
 * A **strobogrammatic number** appears the same when rotated **180 degrees** (viewed upside down).
 * For example, `"69"` is strobogrammatic because it looks the same when flipped upside down, while `"962"` is not.
 *
 * Constraints:
 * - 1 <= num.length <= 50
 * - num contains only digits.
 * - num has no leading zeros except when the number itself is zero.
 *
 * Examples:
 * Input: "69"
 * Output: true
 * Explanation: "69" is strobogrammatic because when rotated 180 degrees, it remains "69".
 *
 * Input: "962"
 * Output: false
 * Explanation: "962" is not strobogrammatic because "2" does not form a valid pair when rotated.
 *
 * Input: "88"
 * Output: true
 * Explanation: "88" is strobogrammatic because it remains "88" when rotated 180 degrees.
 */

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    // Method to check if the number is strobogrammatic
    public static boolean isStrobogrammatic(String num) {
        // Define the valid strobogrammatic pairs as a 2D array
        // These are the valid pairs when flipped 180 degrees
        String[][] strobogrammaticPairs = {{"0", "0"}, {"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};
        
        // Create a map to store the strobogrammatic pairs for quick lookup
        Map<String, String> map = new HashMap<>();
        // Populate the map with valid pairs
        for (String[] pair : strobogrammaticPairs) {
            map.put(pair[0], pair[1]);
        }

        // Initialize two pointers: one at the beginning and one at the end of the string
        int left = 0;
        int right = num.length() - 1;

        // Check strobogrammatic condition by comparing characters from both ends
        while (left <= right) {
            // Convert current characters to string for easy comparison
            String leftChar = String.valueOf(num.charAt(left));
            String rightChar = String.valueOf(num.charAt(right));

            // If the left character does not form a valid strobogrammatic pair with the right character, return false
            if (!map.containsKey(leftChar) || !map.get(leftChar).equals(rightChar)) {
                return false;
            }

            // Move the left pointer to the right and the right pointer to the left
            left++;
            right--;
        }

        // If all pairs are valid, return true
        return true;
    }

}
