package com.prep4faang.prep.dsa.miscellaneous;

/**
 * Problem: Maximum Subarray (Kadane's Algorithm)
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example 1:
 * Input: nums = [1, -2, 3, 4, -1, 2, 1, -5, 4]
 * Output: 9
 * Explanation: The subarray [3, 4, -1, 2, 1] has the largest sum = 9.
 *
 * Example 2:
 * Input: nums = [-2, -3, -1, -5]
 * Output: -1
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 */

public class MaximumSubarray {

    /**
     * Returns the sum of the maximum subarray using Kadane's Algorithm.
     *
     * @param nums the input array
     * @return the maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxEnding = nums[0];
        for(int i=1;i<nums.length;i++){
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }
}
