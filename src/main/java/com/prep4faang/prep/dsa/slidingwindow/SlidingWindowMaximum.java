package com.prep4faang.prep.dsa.slidingwindow;

import java.util.*;

/**
 * Problem: Sliding Window Maximum
 * <p>
 * Given an integer list `nums`, find the maximum values in all the contiguous
 * subarrays (windows) of size `w`.
 * <p>
 * Constraints:
 * - 1 ≤ nums.length ≤ 10^3
 * - -10^4 ≤ nums[i] ≤ 10^4
 * - 1 ≤ w ≤ nums.length
 * <p>
 * Example:
 * Input: nums = [-4, 2, -5, 3, 6], w = 3
 * Output: [2, 3, 6]
 * <p>
 * Explanation:
 * - Window 1: [-4, 2, -5] => max = 2
 * - Window 2: [2, -5, 3] => max = 3
 * - Window 3: [-5, 3, 6] => max = 6
 */
public class SlidingWindowMaximum {

    /**
     * Returns a list of maximum values from each window of size w.
     *
     * @param nums The input array of integers.
     * @param w    The size of the sliding window.
     * @return A list of integers representing the maximum of each window.
     */

    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        if (nums.length < w)
            return new int[]{};

        int n = nums.length;
        int[] result = new int[n - w + 1];

        for (int i = 0; i < n - w + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < w + i; j++) {
                max = Math.max(nums[j], max);
            }
            result[i] = max;
        }

        return result;
    }
}



