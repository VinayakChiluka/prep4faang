package com.prep4faang.prep.dsa.twopointer;

/**
 * Problem Statement:
 * 
 * Given a string word and an abbreviation abbr, return TRUE if the abbreviation matches the given string. Otherwise, return FALSE.
 * 
 * A certain word "calendar" can be abbreviated as follows:
 *  - "cal3ar" → ("cal end ar": skipping 3 characters "end")
 *  - "c6r"    → ("c alenda r": skipping 6 characters "alenda")
 * 
 * The word "internationalization" can also be abbreviated as "i18n" 
 * (skipping 18 characters, leaving 'i' and 'n').
 * 
 * The following are invalid abbreviations:
 *  - "c06r"      → has leading zeroes
 *  - "cale0ndar" → replaces an empty string
 *  - "c24r"      → replaced substrings are adjacent
 * 
 * Constraints:
 *  - 1 <= word.length <= 20
 *  - word consists only of lowercase English letters.
 *  - 1 <= abbr.length <= 10
 *  - abbr consists of lowercase English letters and digits.
 *  - All integers in abbr will fit in a 32-bit integer.
 */

public class WordAbbreviation {

    /**
     * Validates if the given abbreviation is valid for the provided word.
     *
     * @param word The original word.
     * @param abbr The abbreviation to validate.
     * @return true if abbr is a valid abbreviation of word, false otherwise.
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        int wp = 0; // Pointer to track position in the word
        int ap = 0; // Pointer to track position in the abbreviation

        // Traverse both word and abbreviation
        while (wp < word.length() && ap < abbr.length()) {

            // If current abbr character is a digit
            if (Character.isDigit(abbr.charAt(ap))) {
                // Leading zeros are invalid (e.g., "c06r")
                if (abbr.charAt(ap) == '0') {
                    return false;
                }

                int num = 0;
                // Parse full number from abbr (could be multi-digit)
                while (ap < abbr.length() && Character.isDigit(abbr.charAt(ap))) {
                    num = num * 10 + (abbr.charAt(ap) - '0'); // Convert char to digit
                    ap++; // Move to next character in abbreviation
                }

                // Skip 'num' characters in word
                wp += num;
            } else {
                // Ensure characters match at current position
                if (wp >= word.length() || word.charAt(wp) != abbr.charAt(ap)) {
                    return false;
                }
                // Move both pointers ahead
                wp++;
                ap++;
            }
        }

        // Both pointers should reach the end of their respective strings
        return wp == word.length() && ap == abbr.length();
    }
}
