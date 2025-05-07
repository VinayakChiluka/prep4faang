package com.prep4faang.prep.dsa.twopointer;

import java.util.*;

/**
 *  NextPalindrome
 *  --------------
 *  Given a numeric palindrome as a string, find the next‑larger palindrome
 *  that can be formed with exactly the same multiset of digits.
 *  If no such palindrome exists, return the empty string "".
 */
public class NextPalindrome {

    /**
     * Main public API.
     */
    public static String nextPalindrome(String numStr) {
        int n = numStr.length();
        if (n <= 1) return "";                      // cannot get larger

        int halfLen = n / 2;                        // size of *left* half
        boolean isOdd = (n % 2 == 1);

        // 1. Copy ONLY the left half (exclude middle digit if odd length)
        List<Character> left = new ArrayList<>(halfLen);
        for (int i = 0; i < halfLen; i++) {
            left.add(numStr.charAt(i));
        }

        // 2. Try to advance that left half to its next lexicographic perm.
        if (!nextPermutation(left)) return "";      // already at max → no answer

        // 3. Build the result string
        StringBuilder sb = new StringBuilder(n);
        for (char c : left) sb.append(c);

        if (isOdd) {                                // keep original middle
            sb.append(numStr.charAt(halfLen));
        }

        // Mirror the updated left half. For odd length, mirror *only* the
        // left part again; for even length, mirror the entire string so far.
        int mirrorLimit = isOdd ? halfLen : sb.length();
        for (int i = mirrorLimit - 1; i >= 0; i--) {
            sb.append(sb.charAt(i));
        }

        // 4. Final safety check (redundant, but keeps contract explicit)
        return sb.toString().compareTo(numStr) > 0 ? sb.toString() : "";
    }

    /**
     * In‑place next‑permutation for a List<Character>.
     * @return true  if permutation advanced;
     *         false if already the highest permutation.
     */
    private static boolean nextPermutation(List<Character> a) {
        int i = a.size() - 2;
        // find first index where a[i] < a[i+1] scanning from right
        while (i >= 0 && a.get(i) >= a.get(i + 1)) i--;
        if (i < 0) return false;                    // non‑increasing → max

        int j = a.size() - 1;
        // find smallest digit > a[i] to the right of i
        while (a.get(j) <= a.get(i)) j--;

        Collections.swap(a, i, j);                  // swap pivot with next‑bigger
        Collections.reverse(a.subList(i + 1, a.size())); // reverse tail
        return true;
    }

    /* ---------------------- simple demo ---------------------- */
    public static void main(String[] args) {
        System.out.println(nextPalindrome("123321"));     // 132231
        System.out.println(nextPalindrome("455554"));     // 545545
        System.out.println(nextPalindrome("9876789"));    // ""
        System.out.println(nextPalindrome("37444743"));   // 43477434
    }
}
