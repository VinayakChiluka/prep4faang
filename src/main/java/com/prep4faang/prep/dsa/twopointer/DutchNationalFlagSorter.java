package com.prep4faang.prep.dsa.twopointer;


import java.util.*;

/**
 * Utility class to sort an array consisting of 0s, 1s, and 2s in-place.
 */
public class DutchNationalFlagSorter {

    /**
     * Sorts the input array containing only 0s, 1s, and 2s in-place such that
     * all 0s (red) come first, followed by 1s (white), and then 2s (blue).
     * This is a variation of the Dutch National Flag problem.
     *
     * <p>The function does not use any built-in sort methods and completes
     * the sort in a single pass with constant space.</p>
     *
     * Constraints:
     * <ul>
     *   <li>1 ≤ colors.length ≤ 300</li>
     *   <li>colors[i] ∈ {0, 1, 2}</li>
     * </ul>
     *
     * @param colors An array representing colors: 0 (red), 1 (white), and 2 (blue).
     * @return The sorted array with elements in the order of red (0), white (1), and blue (2).
     */
    public  int[] sortColors(int[] colors) {
        int start = 0, end = colors.length - 1, current = 0;
        while (current <= end) {
            if (colors[current] == 0) {
                swap(colors, start, current);
                current++;
                start++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                swap(colors, current, end);
                end--;
                // Do not increment current here to recheck the swapped value
            }
        }
        return colors;
    }

    private  void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
