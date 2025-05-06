package com.prep4faang.prep.dsa.twopointer;

public class MinMovesToMakePalindrome {
    public static int minMovesToMakePalindrome(String s) {
        int moves = 0;
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {

            // case 1 – already matched
            if (chars[i] == chars[j]) {
                i++;
                j--;
                continue;
            }

            // case 2 – need to find a partner for chars[i]
            int k = j;
            while (k > i && chars[k] != chars[i]) {
                k--;
            }

            if (k == i) {                 // chars[i] is the unique middle char
                // move it one step toward the centre
                char tmp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = tmp;
                moves++;
            } else {                      // found a match at k, bubble it to j
                while (k < j) {
                    char tmp = chars[k];
                    chars[k] = chars[k + 1];
                    chars[k + 1] = tmp;
                    k++;
                    moves++;
                }
                i++;
                j--;
            }
        }
        return moves;
    }
}
